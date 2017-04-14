package me.meyProjects.microservice.core.validator;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;

/**
 * Created by chendong on 2017/1/4.
 * <p>
 * 有多个值且使用“,”分开时 使用此类验证
 */
public class StringArrayValidator implements Validator {

    private Set<String> shouldValues = Sets.newHashSet();

    public StringArrayValidator(String... shouldValues) {
        Collections.addAll(this.shouldValues, shouldValues);
    }

    @Override
    public String validate(String key, String valueArray) {
        String message = null;
        String[] values = valueArray.split(",");
        for (String value : values) {
            if (!shouldValues.contains(value)){
                message = String.format("%s值%s不在可选范围内", key, value);
                break;
            }
        }
        return message;
    }
}
