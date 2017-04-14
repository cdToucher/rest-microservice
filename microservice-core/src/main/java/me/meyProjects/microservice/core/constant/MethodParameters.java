package me.meyProjects.microservice.core.constant;

import uyun.octopus.openApi.core.utils.ParamsHolder;
import uyun.octopus.openApi.core.validator.Validator;

import static uyun.octopus.openApi.core.constant.RequestParam.*;
import static uyun.octopus.openApi.core.constant.RequestParam.TENANT_ID;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * rest api 对应的参数
 */
public enum MethodParameters {

    REST_TEST("restTest", TENANT_ID);

    private String method;//对应的aop方法名字

    private RequestParam[] requestParams;

    public String getMethod() {
        return method;
    }

    public RequestParam[] getRequestParams() {
        return requestParams;
    }

    MethodParameters(String method, RequestParam... requestParams) {
        this.method = method;
        this.requestParams = requestParams;
    }

    /*
    判断是否包含某个参数
     */
    public static boolean contains(String method, String key) {
        MethodParameters p = null;
        for (MethodParameters methodParameters : MethodParameters.values()) {
            if (methodParameters.getMethod().equals(method))
                p = methodParameters;
        }

        boolean isContains = false;
        if (p != null) {
            for (RequestParam requestParam : p.getRequestParams()) {
                if (requestParam.getName().equals(key)) {
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }

    /**
     * 验证方法
     *
     * @param method 执行的api方法
     * @return 验证结果
     */
    public static String validate(String method) {
        MethodParameters p = null;
        for (MethodParameters methodParameters : MethodParameters.values()) {
            if (methodParameters.getMethod().equals(method))
                p = methodParameters;
        }
        if (p == null)
            return null;


        RequestParam[] requestParams = p.getRequestParams();
        for (RequestParam param : requestParams) {
            String paramName = param.getName();
            if (!param.isRequired())
                continue;
            if (!ParamsHolder.contains(paramName))
                return String.format("%s未提供", paramName);
        }


        String message = null;
        for (RequestParam param : requestParams) {
            if (message != null)
                break;
            String paramName = param.getName();
            if (!param.isRequired() && !ParamsHolder.contains(paramName))
                continue;
            Validator[] validators = param.getValidators();
            for (Validator validator : validators) {
                if (message == null) {
                    String value = ParamsHolder.getParamString(paramName);
                    if (value == null)
                        value = ParamsHolder.getCookieParamString(paramName);
                    message = validator.validate(paramName, value);
                }
            }
        }
        return message;
    }

}
