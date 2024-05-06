package com.common.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RequestLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);

    @Around("execution(*.controller.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get request arguments
        Object[] args = joinPoint.getArgs();

        // Log request details
        logger.info("Invoking method: {} with arguments: {}", joinPoint.getSignature().getName(), Arrays.toString(args));

        // Proceed with the actual method execution
        Object result = joinPoint.proceed();

        // Log response
        logger.info("Response: " + result);
    }

}
