package me.myProjects.microservice.core.validator;

import java.util.Date;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 时间戳验证
 */
public class TimestampValidator implements Validator {

    public static final TimestampValidator validator = new TimestampValidator();

    private TimestampValidator() {
    }

    @Override
    public String validate(String key, String value) {
        String message = null;
        try {
            long timestamp = Long.valueOf(value);
            Date date = new Date(timestamp);
        } catch (NumberFormatException ex) {
            message = String.format("%s时间戳格式不正确", key);
        }
        return message;
    }
}
