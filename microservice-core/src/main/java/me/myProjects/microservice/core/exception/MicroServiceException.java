package me.myProjects.microservice.core.exception;


import me.myProjects.microservice.core.constant.HttpStatusCode;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * OctopusOpenApi
 */
public class MicroServiceException extends RuntimeException {

    private static final long serialVersionUID = 4699514648326342625L;

    public MicroServiceException() {
        super(HttpStatusCode._500.getDescriptionC());
    }

    public MicroServiceException(String message) {
        super(message);
    }

    public MicroServiceException(String msg, Throwable t) {
        super(msg, t);
    }
}
