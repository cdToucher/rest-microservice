package me.myProjects.microservice.core.utils;


import me.myProjects.microservice.core.bean.Parameters;

import java.util.Map;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 存储参数
 */
public class ParamsHolder {

    private static final ThreadLocal<Parameters> holder = new ThreadLocal<>();

    private ParamsHolder() {

    }

    private static void setOne() {
        holder.set(new Parameters());
    }

    public static Parameters getParams() {
        if (holder.get() == null)
            setOne();
        return holder.get();
    }

    public static void setParameter(String key, Object value) {
        Parameters parameters = getParams();
        if (parameters != null) {
            parameters.getParams().put(key, value);
        }
    }

    public static void setCookieParameter(String key, Object value) {
        Parameters parameters = getParams();
        if (parameters != null) {
            parameters.getCookieParams().put(key, value);
        }
    }

    public static String getParamString(String key) {
        Map<String, Object> params = getParams().getParams();
        String result;
        if (params == null)
            return null;
        else {
            result = params.get(key) == null ? null : String.valueOf(params.get(key));
        }
        return result;
    }

    public static String getCookieParamString(String key) {
        Map<String, Object> params = getParams().getCookieParams();
        String result;
        if (params == null)
            return null;
        else {
            result = params.get(key) == null ? null : String.valueOf(params.get(key));
        }
        return result;
    }

    public static boolean contains(String paramName) {
        return getParams().getParams().containsKey(paramName) |
                getParams().getCookieParams().containsKey(paramName);
    }
}
