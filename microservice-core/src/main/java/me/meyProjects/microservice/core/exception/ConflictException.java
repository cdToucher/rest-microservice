package me.meyProjects.microservice.core.exception;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * ConflictException
 */
public class ConflictException extends RuntimeException {
    private static final long serialVersionUID = -748299267605673093L;

    public ConflictException(String msg) {
        super(msg);
    }

    public ConflictException(String msg, Throwable t) {
        super(msg, t);
    }
}
