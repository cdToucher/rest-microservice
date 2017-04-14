package me.meyProjects.microservice.core.validator;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 数字验证器
 */
public class NumberValidator implements Validator {

    public static final NumberValidator validator = new NumberValidator();

    private NumberValidator() {
    }

    @Override
    public String validate(String key, String value) {
        String message = null;
        try {
            Double.valueOf(value);
        } catch (NumberFormatException e) {
            message = String.format("%s应该为数字", key);
        }
        return message;
    }

}
