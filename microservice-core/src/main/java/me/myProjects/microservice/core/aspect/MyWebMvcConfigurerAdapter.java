package me.myProjects.microservice.core.aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chendong on 2017/4/20.
 * <p>
 * 静态资源 获取配置
 * <p>
 * WebMvcConfigurerAdapter 中存在 一些好用 adepter method
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 配置静态访问资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/rs/**").addResourceLocations("classpath:/my/");
        super.addResourceHandlers(registry);
    }

    /**
     * 重定向
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/toLogin", "login");
        super.addViewControllers(registry);
    }

}