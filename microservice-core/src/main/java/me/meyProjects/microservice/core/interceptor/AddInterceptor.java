package me.meyProjects.microservice.core.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chendong on 2016/12/14.
 * <p>
 * 添加监听器
 */
@Configuration
public class AddInterceptor extends WebMvcConfigurerAdapter {

    private final DummyInterceptor dummyControlInterceptor;

    @Autowired
    public AddInterceptor(DummyInterceptor dummyControlInterceptor) {
        this.dummyControlInterceptor = dummyControlInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dummyControlInterceptor).addPathPatterns("/**");
    }

}
