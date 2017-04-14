package me.meyProjects.microservice.core.validator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chendong on 2017/1/9.
 * <p>
 * URI 验证器
 */
public class UriValidator implements Validator {

    public static final UriValidator validator = new UriValidator();

    @Override
    public String validate(String key, String value) {
        String message = null;
        boolean isWrongUri = false;
        try {
            new URL(value);
        } catch (MalformedURLException ex) {
            isWrongUri = true;
        }
        try {
            if (isWrongUri) {
                new URL("http://" + value);
                isWrongUri = false;
            }
        } catch (MalformedURLException ex) {
            isWrongUri = true;
        }
        try {
            if (isWrongUri) {
                new URL("http://www." + value);
                isWrongUri = false;
            }
        } catch (MalformedURLException ex) {
            isWrongUri = true;
        }
        if (isWrongUri)
            message = String.format("%s非正确格式", key);
        return message;
    }
}
