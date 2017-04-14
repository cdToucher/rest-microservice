package me.meyProjects.microservice.core.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uyun.octopus.openApi.core.exception.NotFoundException;

/*
处理 404 页面
 */
@Controller
public class PageNoteFoundErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String handleError() {
        throw new NotFoundException();
        //return JSON.toJSONString(HttpStatusCode.getErrorMessage(HttpStatusCode._404, HttpStatusCode._404.getDescriptionE()));
        //这里不能直接返回？有待研究
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}