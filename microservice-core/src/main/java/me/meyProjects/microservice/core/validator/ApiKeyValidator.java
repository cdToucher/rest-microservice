package me.meyProjects.microservice.core.validator;

/**
 * Created by chendong on 2016/12/21.
 * <p>
 * api key 检测类
 */
public class ApiKeyValidator implements Validator {

    @Override
    public String validate(String key, String value) {
        String message = null;
        if (value == null)
            message = String.format("%s格式不正确", key);
        return message;
    }
}
