package me.myProjects.microservice.core.aspect;

import com.alibaba.fastjson.JSON;
import me.myProjects.microservice.core.bean.Parameters;
import me.myProjects.microservice.core.constant.HttpStatusCode;
import me.myProjects.microservice.core.constant.MethodParameters;
import me.myProjects.microservice.core.utils.ParamsHolder;
import me.myProjects.microservice.core.exception.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chendong on 2016/12/15.
 * <p>
 * 参数校验 \ 异常捕获
 */
@Aspect
@Component
public class ParamsValidatorHandler {

    private static final Logger log = LoggerFactory.getLogger(ParamsValidatorHandler.class);

    /* 声明切入点：此处定义后仅作为标示符用  */
    @Pointcut("execution(public * uyun.octopus.openApi.core.controller.*.*(..))")
    public void pointcut() {

    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
    }


    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws UnauthorizedRequestException {
    /* 参数验证   */
        final String method = pjp.getSignature().getName();
        if (log.isDebugEnabled()) {
            log.debug("Begin to execute rest method >>>>>>> :: " + method + ",  params: " + JSON.toJSONString(ParamsHolder.getParams()));
        }

        Parameters parameters = ParamsHolder.getParams(); // 去除不必要的参数
        String[] paramsKey = parameters.getParams().keySet().stream().toArray(String[]::new);
        for (String key : paramsKey) {
            if (!MethodParameters.contains(method, key))
                parameters.getParams().remove(key);
        }

        String[] cookieParamsKey = parameters.getCookieParams().keySet().stream().toArray(String[]::new);
        for (String key : cookieParamsKey) {
            if (!MethodParameters.contains(method, key))
                parameters.getCookieParams().remove(key);
        }

        String message = MethodParameters.validate(method);
        if (message != null) {
            throw new BadRequestException(message);
        }

        try {
            return pjp.proceed();
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            throw new NotFoundException(HttpStatusCode._404.getDescriptionE());
        } catch (ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch (RequestTimeoutException e) {
            throw new RequestTimeoutException(e.getMessage());
        } catch (UnauthorizedRequestException e) {
            throw new UnauthorizedRequestException(e.getMessage());
        } catch (Throwable e) {
            log.error("Execute around aspect error.", e);
            throw new MicroServiceException();
        }
    }
}
