package com.yuntu.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
/*
* 增强类
* */
import java.util.Arrays;
@Aspect
public class UserBizLogger {
    private static final Logger log = Logger.getLogger(UserBizLogger.class);
    //将切点提取出来   切点注解
    @Pointcut("execution(public int addUser(com.yuntu.pojo.User))")
    public void pointCut(){}
    //前置增强
//    @Before("pointCut()")
    public void before(JoinPoint jp){
            log.debug("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,传递的参数为："+ Arrays.toString(jp.getArgs()));
    }
    //后置增强
//    @AfterReturning(pointcut = "pointCut()" ,returning = "result")
    public void after(JoinPoint jp ,Object result){
        log.debug("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,返回值为："+ result);
    }

    //最终曾强
//    @After("pointCut()")
    public void afterFinal(JoinPoint jp){
        log.debug(jp.getSignature().getName()+"方法结束");
    }

    //环绕增强(4合1)
    @Around("pointCut()")
    public Object aroundLogger(ProceedingJoinPoint jp){
        //前置增强
        log.debug("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,传递的参数为："+ Arrays.toString(jp.getArgs()));
        Object result=null;
        try {
            result  = jp.proceed();
            result=111111;
            log.debug("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,返回值为："+result );
        } catch (Throwable throwable) {
            log.error(jp.getSignature().getName()+"方法发生异常"+throwable);
            throwable.printStackTrace();
        } finally {
                log.debug(jp.getSignature().getName()+"方法结束");
        }
        return result;
    }
}
