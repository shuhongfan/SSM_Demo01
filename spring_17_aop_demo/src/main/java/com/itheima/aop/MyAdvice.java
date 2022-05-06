package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.itheima.dao.BookDao.*d*(..))")
    private void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------------------------------");
        Long startTime = System.currentTimeMillis();
        for (int i = 0 ; i<10000 ; i++) {
            //调用原始操作
            pjp.proceed();
        }
        Long endTime = System.currentTimeMillis();
        Long totalTime = endTime-startTime;
        System.out.println("执行万次消耗时间：" + totalTime + "ms");
        return null;
    }

}
