package me.myProjects.microservice.core.exception;


import me.myProjects.microservice.core.constant.HttpStatusCode;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 未授权访问错误
 */
public class UnauthorizedRequestException extends Exception {

    private static final long serialVersionUID = 5696364889817554553L;

    public UnauthorizedRequestException() {
        super(HttpStatusCode._401.getDescriptionC());
    }

    public UnauthorizedRequestException(String msg) {
        super(msg);
    }

    public UnauthorizedRequestException(String msg, Throwable t) {
        super(msg, t);
    }


}
