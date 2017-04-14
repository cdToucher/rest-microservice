package me.meyProjects.microservice.core.bean;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by chendong on 2016/12/15.
 *
 * 存储线程中的request params
 */
public class Parameters {

    public Map<String, Object> getParams() {
        return params;
    }

    public Map<String, Object> getCookieParams() {
        return cookieParams;
    }

    private Map<String, Object> params = Maps.newHashMap();

    private Map<String, Object> cookieParams = Maps.newHashMap();
}
