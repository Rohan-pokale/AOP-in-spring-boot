package com.codingshuttle.aopApp.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(* orderPackage(..))") //work for all orderPackage method in any class and package
//    @Before("execution(* com.codingshuttle.aopApp.services.impl.ShipmentServiceImpl.orderPackage(..))") // work only for orderPackage()
    @Before("execution(* com.codingshuttle.aopApp.services.impl.*.*(..))") // work only for all class and method in impl package
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("beforeOrderPackage called from logging aspect, {}",joinPoint.getKind());
        log.info("beforeOrderPackage called from logging aspect, {}",joinPoint.getSignature());

    }

    @Before("within(com.codingshuttle.aopApp.services.impl.*)") // work only for all class and method in impl package
    public void beforeServiceImplCalls(JoinPoint joinPoint){
        log.info("Service Impl Called {}",joinPoint.getThis());
    }

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactional(JoinPoint joinPoint){
        log.info("before transactional is Called {}",joinPoint.getThis());
    }
}
