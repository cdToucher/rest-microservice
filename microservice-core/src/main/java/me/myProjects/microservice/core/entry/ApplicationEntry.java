package me.myProjects.microservice.core.entry;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.InetAddress;

@SpringBootApplication
public class ApplicationEntry {

    private static final String LOGBACK_XML_SUFFIX = "/conf/logback.xml";
    private static final String APP_HOME = "app.home";
    private static final String HOSTNAME = "hostname";

    public static void main(String[] args) throws Exception {
        System.setProperty("env", "dev");
        System.setProperty(HOSTNAME, InetAddress.getLocalHost().getHostName());
        if (args.length > 0) {
            String appHome = args[0];
            configureLogbackPath(appHome);
            System.setProperty(APP_HOME, appHome);
        }
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DisconfConfig.class);
        ctx.start();
        ctx.stop();
        SpringApplication.run(ApplicationConfig.class, args);
    }

    /**
     * 配置logback配置文件路径
     *
     * @param appHome 安装路径
     */
    private static void configureLogbackPath(String appHome) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);

        // Call context.reset() to clear any previous configuration, e.g. default
        // configuration. For multi-step configuration, omit calling context.reset().
        context.reset();

        try {
            configurator.doConfigure(appHome + LOGBACK_XML_SUFFIX);
        } catch (JoranException e) {
            e.printStackTrace();
        }

        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
}


