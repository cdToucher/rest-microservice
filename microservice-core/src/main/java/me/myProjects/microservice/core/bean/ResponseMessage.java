package me.myProjects.microservice.core.bean;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by chendong on 2017/1/3.
 * <p>
 * 返回信息
 */
public class ResponseMessage {

    public static String successMessage() {
        Map<String, String> success = Maps.newHashMap();
        success.put("message", "success");
        return JSON.toJSONString(success);
    }

    public static String failureMessage() {
        Map<String, String> success = Maps.newHashMap();
        success.put("message", "failure");
        return JSON.toJSONString(success);
    }

    public static String failureMessage(String message) {
        Map<String, String> success = Maps.newHashMap();
        success.put("message", message);
        return JSON.toJSONString(success);
    }

    public static String alreadyPresent(String key) {
        Map<String, String> presence = Maps.newHashMap();
        presence.put("message", String.format("%s已经存在", key));
        return JSON.toJSONString(presence);
    }
}
