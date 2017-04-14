package me.meyProjects.microservice.core.constant;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by chendong on 2016/12/14.
 * <p>
 * http 响应码
 */
public enum HttpStatusCode {

    _400(400, "Bad Request", "错误请求"),
    _401(401, "Unauthorized request", "未授权访问"),
    _404(404, "Not Found", "资源不存在"),
    _408(408, "Request Timeout", "请求超时"),
    _409(409, "Conflict", "资源冲突"),
    _500(500, "Internal Server Error", "服务器内部错误");

    private int code;

    private String descriptionE;

    private String descriptionC;


    public int getCode() {
        return code;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public String getDescriptionC() {
        return descriptionC;
    }


    HttpStatusCode(int code, String descriptionE, String descriptionC) {
        this.code = code;
        this.descriptionE = descriptionE;
        this.descriptionC = descriptionC;
    }

    public static Map<String, Object> getErrorMessage(HttpStatusCode code, String message) {
        Map<String, Object> errorMap = Maps.newHashMap();
        Map<String, Object> error = Maps.newHashMap();
        error.put("code", code.getCode());
        error.put("message", message);
        errorMap.put("error", error);
        return errorMap;
    }

}
