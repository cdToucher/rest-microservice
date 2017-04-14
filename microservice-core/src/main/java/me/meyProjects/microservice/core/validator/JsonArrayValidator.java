package me.meyProjects.microservice.core.validator;

import com.alibaba.fastjson.JSON;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * json array验证
 */
public class JsonArrayValidator implements Validator {

    @Override
    public String validate(String key, String value) {
        String message = null;
        try {
            JSON.parseArray(value);
        } catch (Exception e) {
            message = String.format("%s应该为jsonArray格式", key);
        }
        return message;
    }
}
