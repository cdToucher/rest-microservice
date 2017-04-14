package me.myProjects.microservice.core.validator;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 整数范围验证
 */
public class IntRangeValidator implements Validator {


    private long from;
    private long to;

    public IntRangeValidator(long from, long to) {
        this.to = to;
        this.from = from;
    }

    @Override
    public String validate(String key, String value) {
        long valueLong = Long.valueOf(value);
        String message = null;
        if (from < valueLong & valueLong > to)
            message = String.format("%s值必须为%s到%s的整数", key, from, to);
        return message;
    }
}
