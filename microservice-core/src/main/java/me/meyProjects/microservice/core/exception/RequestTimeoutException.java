package me.meyProjects.microservice.core.exception;

/**
 * Created by chendong on 2016/12/15.
 *
 * RequestTimeoutException
 */
public class RequestTimeoutException extends RuntimeException {

    private static final long serialVersionUID = -2570685042340296409L;

    public RequestTimeoutException(String msg) {
        super(msg);
    }

    public RequestTimeoutException(String msg, Throwable t) {
        super(msg, t);
    }
}
