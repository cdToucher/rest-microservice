package me.myProjects.microservice.core.validator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * jsonArray 值判断
 */
public class JsonRangeValidator implements Validator {

    private Set<String> shouldValues = Sets.newHashSet();

    public JsonRangeValidator(String... values) {
        Collections.addAll(this.shouldValues, values);
    }

    @Override
    public String validate(String key, String value) {
        String message = null;
        try {
            JSONArray jsonArray = JSON.parseArray(value);
            if (jsonArray != null) {
                for (Object obj : jsonArray) {
                    if (!shouldValues.contains(obj.toString()))
                        message = String.format("%s值%s不在可选范围内", key, obj.toString());
                }
            }
        } catch (Exception e) {
            message = String.format("%sJSON ARRAY格式错误", key);
        }
        return message;
    }
}
