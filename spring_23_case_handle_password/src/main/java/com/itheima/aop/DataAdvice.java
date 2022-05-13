package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataAdvice {
    @Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
    private void servicePt(){}

    @Around("servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            //判断参数是不是字符串
            if(args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }
//        如果不把args传入的话，运行原始方法使用的还是原来的参数
        Object ret = pjp.proceed(args);
        return ret;
    }

/**
 * AOP（Aspect Oriented Programming） 面向切面编程，一种编程范式
 * 作用：在不惊动原始设计的基础上为方法进行功能增强
 *
 * 核心概念：
 *  代理（proxy）：SpringAOP的核心本质是采用代理模式实现的
 *  连接点（JoinPoint）：在springAOP中，理解为任意方法的执行
 *  切入点（Pointcut）：匹配连接点的式子，也是具有共性功能的方法描述
 *  通知（Advice）：若干个方法的共性功能，在切入点处执行，最终体现为一个方法
 *  切面（Aspect）：描述通知与切入点的对应关系
 *  目标对象（Target）：被代理的原始对象成为目标对象
 *
 *
 */
}
