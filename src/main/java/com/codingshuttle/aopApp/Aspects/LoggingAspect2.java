package com.codingshuttle.aopApp.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect2 {

    @Before("allServicePointCut()")
    public void beforeServiceMethodsCalled(JoinPoint joinPoint){
        log.info("before advice method called for method in services impl {}",joinPoint.getSignature());
    }

    @After("allServicePointCut()")
    public void afterServiceMethodsCalled(JoinPoint joinPoint){
        log.info("after advice method called for method in services impl {}",joinPoint.getSignature());
    }

    @AfterReturning(value = "allServicePointCut()",returning = "returnVal")
    public void afterReturningServiceMethodsCalled(JoinPoint joinPoint,Object returnVal ){
        log.info("after returning advice method called for method in services impl {}",joinPoint.getSignature());
        log.info("return value :{}",returnVal);
    }

    @AfterThrowing(value = "allServicePointCut()")
    public void afterThrowingServiceMethodsCalled(JoinPoint joinPoint){
        log.info("after throwing advice method called for method in services impl {}",joinPoint.getSignature());
    }


    @Pointcut("execution(* com.codingshuttle.aopApp.services.impl.*.*(..))")
    public void allServicePointCut(){

    }
}
