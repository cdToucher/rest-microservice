package me.meyProjects.microservice.core.exception;


import me.meyProjects.microservice.core.constant.HttpStatusCode;

/**
 * Created by chendong on 2016/12/15.
 *
 * BadRequest
 */
public class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = 46074784096285854L;

    public BadRequestException() {
        super(HttpStatusCode._400.getDescriptionC());
    }

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(String msg, Throwable t) {
        super(msg, t);
    }
}
