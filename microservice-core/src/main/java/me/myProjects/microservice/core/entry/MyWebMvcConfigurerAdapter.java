package me.myProjects.microservice.core.entry;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chendong on 2017/4/20.
 * <p>
 * 静态资源 获取配置
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
}