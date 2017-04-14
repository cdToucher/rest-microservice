package me.myProjects.microservice.core.constant;

/**
 * Created by chendong on 2017/1/10.
 *
 * 返回参数
 */
public enum ResponseParam {


    APP_ID("app_id");

    public String key() {
        return name;
    }

    private String name;

    ResponseParam(String name) {
        this.name = name;
    }
}
