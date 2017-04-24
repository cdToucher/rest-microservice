package me.myProjects.microservice.core.entry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by chendong on 2016/12/14.
 * <p>
 * application configuration
 */
@ComponentScan(basePackages = "me.myProjects.microservice.core")  // 组件扫描
@MapperScan("me.myProjects.microservice.core.mapper")
@Configuration
@ImportResource({"classpath:dubbo-service.xml"})
public class ApplicationConfig implements ApplicationContextAware {

    public static ApplicationContext getCtx() {
        return ctx;
    }

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ctx = context;
    }

}
