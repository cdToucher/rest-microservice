package me.meyProjects.microservice.core.validator;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 验证器
 */
public interface Validator {

    String validate(String key, String value);

}
