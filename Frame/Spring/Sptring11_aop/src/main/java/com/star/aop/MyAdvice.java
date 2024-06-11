package com.star.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.star.dao.*Dao.update(..))")
    public void pt(){}

    //@Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }

    @Around("pt()")
    public Object method2(ProceedingJoinPoint pjp) throws Throwable {
        Object[] objects = pjp.getArgs();
        objects[0] = "lisi";
        System.out.println("around before advice...");
        Object obj = pjp.proceed(objects);
        System.out.println("around after advice...");
        return obj;
    }
}
