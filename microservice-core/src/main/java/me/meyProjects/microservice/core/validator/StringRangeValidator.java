package me.meyProjects.microservice.core.validator;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 参数可选判断
 */
public class StringRangeValidator implements Validator {


    private Set<String> shouldValues = Sets.newHashSet();

    public StringRangeValidator(String... shouldValues) {
        Collections.addAll(this.shouldValues, shouldValues);
    }

    @Override
    public String validate(String key, String value) {
        String message = null;
        if (!shouldValues.contains(value))
            message = String.format("%s值%s不在可选范围内", key, value);
        return message;
    }
}

