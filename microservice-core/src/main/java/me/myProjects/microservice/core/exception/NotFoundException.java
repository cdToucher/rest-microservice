package me.myProjects.microservice.core.exception;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * serialVersionUID
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -4863753261094980535L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
