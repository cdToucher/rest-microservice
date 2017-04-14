package me.meyProjects.microservice.core.validator;

import org.springframework.util.StringUtils;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 非空判断
 */
public class NotEmptyValidator implements Validator {

    public static final NotEmptyValidator validator = new NotEmptyValidator();

    private NotEmptyValidator() {

    }

    @Override
    public String validate(String key, String value) {
        if (!StringUtils.isEmpty(value))
            return null;
        else {
            return String.format("%s不能为空", key);
        }
    }

}
