package me.myProjects.microservice.core.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by chendong on 2016/12/20.
 * <p>
 * request 拦截器
 */
//@Component
public class RequestInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {

    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
