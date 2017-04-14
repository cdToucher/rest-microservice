package me.myProjects.microservice.core.aspect;

import me.myProjects.microservice.core.constant.HttpStatusCode;
import me.myProjects.microservice.core.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 全局异常处理机制
 */
@ControllerAdvice
public class GlobalControlExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleError(Exception e) throws Exception {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MicroServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleOctopusOpenApiError(MicroServiceException e) throws Exception {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleConflict(ConflictException e) {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._409, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFound(NotFoundException e) {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._404, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RequestTimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public Map<String, Object> handleRequestTimeout(RequestTimeoutException e) {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._408, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UnauthorizedRequestException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> handleUnauthorizedRequest(UnauthorizedRequestException e) {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._401, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBadRequest(BadRequestException e) {
        return HttpStatusCode.getErrorMessage(HttpStatusCode._400, e.getMessage());
    }

}
