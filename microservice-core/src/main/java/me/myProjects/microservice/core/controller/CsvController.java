package me.myProjects.microservice.core.controller;

import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.conversions.Conversion;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import me.myProjects.microservice.core.export.dto.AppearanceGuy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.stream.Stream;

@RestController
public class CsvController {


    @RequestMapping("/exportAppearanceGuy")
    public void exportAppearanceGuy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename="
                + URLEncoder.encode("AppearanceGuy", "UTF-8") + ".csv");

        AppearanceGuy appearanceGuy = new AppearanceGuy();
        appearanceGuy.setName("abc");
        appearanceGuy.setAge(3);
        appearanceGuy.setHow(123L);
        appearanceGuy.setKind("selfish");
        appearanceGuy.setSex("male");

        export(response, Stream.of(appearanceGuy, appearanceGuy), AppearanceGuy.class);
    }

    private <T> void export(HttpServletResponse response, Stream<T> content, Class<T> tClass) throws IOException {
        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(new BeanWriterProcessor<>(tClass));
        CsvWriter writer = new CsvWriter(response.getOutputStream(), Charset.forName("GBK"), settings);
        writer.writeHeaders();
        content.forEach(writer::processRecord);
        writer.close();
    }


}
