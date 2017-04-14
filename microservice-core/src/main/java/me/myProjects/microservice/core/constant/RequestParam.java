package me.myProjects.microservice.core.constant;


import me.myProjects.microservice.core.validator.*;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 请求参数
 */
public enum RequestParam {

    API_KEY("apikey", true, NotEmptyValidator.validator, new ApiKeyValidator()),
    APP_ID("app_id", true, NotEmptyValidator.validator),
    PLATFORM("platform", true, NotEmptyValidator.validator),
    URLS("urls", true, new JsonArrayValidator()),
    URL("url", false, UriValidator.validator),
    TENANT_ID("tenant_id", true, NotEmptyValidator.validator),
    PAGE_INDEX("page_index", false, NotEmptyValidator.validator, NumberValidator.validator),
    PAGE_SIZE("page_size", false, NotEmptyValidator.validator, NumberValidator.validator, new IntRangeValidator(1, 500)),
    START_TIME("start_time", true, NotEmptyValidator.validator, TimestampValidator.validator),
    END_TIME("end_time", true, NotEmptyValidator.validator, TimestampValidator.validator),
    STATUS("status", true, NotEmptyValidator.validator, new StringRangeValidator("0", "1")),
    DATA_TYPE("data_type", false, NotEmptyValidator.validator, new StringArrayValidator(MetricDataType.dataTypes));

    public String getName() {
        return name;
    }

    public Validator[] getValidators() {
        return validators;
    }

    public boolean isRequired() {
        return isRequired;
    }

    private String name;

    private Validator[] validators;

    private boolean isRequired;

    RequestParam(String name, boolean isRequired, Validator... validators) {
        this.name = name;
        this.validators = validators;
        this.isRequired = isRequired;
    }

}
