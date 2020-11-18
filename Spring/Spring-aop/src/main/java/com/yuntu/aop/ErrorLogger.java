package com.yuntu.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class ErrorLogger {
    private static final Logger log = Logger.getLogger(ErrorLogger.class);

    @Pointcut("execution(public int addUser(com.yuntu.pojo.User))")
    public void pointCut(){}

    @AfterThrowing(pointcut = "pointCut ()" ,throwing = "e")
    public void afterThrowing(JoinPoint jp , RuntimeException e){
        log.error(jp.getSignature().getName()+"方法发生异常"+e);

    }
}
