package me.myProjects.microservice.core.interceptor;

import me.myProjects.microservice.core.constant.RequestParam;
import me.myProjects.microservice.core.exception.MicroServiceException;
import me.myProjects.microservice.core.exception.UnauthorizedRequestException;
import me.myProjects.microservice.core.utils.ParamsHolder;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by chendong on 2016/12/14.
 * <p>
 * this is a interceptor to auth the token and  get all the params
 */
@Component
public class DummyInterceptor implements HandlerInterceptor {

    private final static Logger log = LoggerFactory.getLogger(DummyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        getParameters(request);
        if ("dev".equals(System.getProperty("env"))) // 本地开发是设置为不必通过验证
            return true;

        String apiKey = ParamsHolder.getParamString(RequestParam.API_KEY.getName());
        boolean failed;
        try {
            failed = !auth(apiKey);
        } catch (Exception e) {
            log.error(String.format("auth failed, apiKey:%s.", apiKey));
            throw new MicroServiceException();
        }
        if (failed)
            throw new UnauthorizedRequestException(String.format("unauthorized apiKey:%s.", apiKey));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }

    private void getParameters(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
        getParams(request);
        getCookieParams(request);
    }

    private void getParams(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
        String contentType = request.getHeader("content-type");
        if (contentType != null && contentType.startsWith("multipart/form-data;")) { // form-data 格式解析
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            Map<String, List<FileItem>> formDataParamMap = upload.parseParameterMap(request);
            for (Map.Entry<String, List<FileItem>> entry : formDataParamMap.entrySet()) {
                String key = entry.getKey();
                List<FileItem> valueList = entry.getValue();
                FileItem item = valueList.get(0);
                Object value;
                if (item.getContentType() != null && item.getContentType().startsWith("image/png")) { // 这里暂时只解析 text 或者image/png 编码的,否则会报错
                    value = item.get();
                } else {
                    value = new String(item.get(), Charset.defaultCharset());
                }
                ParamsHolder.setParameter(key, value);
            }
        } else {
            Enumeration paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement().toString();
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length > 0) {
                    String paramValue = paramValues[0];
                    ParamsHolder.setParameter(paramName, paramValue);
                }
            }
        }
    }

    private void getCookieParams(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                ParamsHolder.setParameter(cookie.getName(), cookie.getValue());
            }
        }
    }

    private boolean auth(String apiKey) {
        if (!StringUtils.isEmpty(apiKey)) {
            // method to conferm
            //invoke dubbo(RPC) service to auth the apikey or token which could be used to verify the identity.
            return true;
        }
        return false;
    }


}
