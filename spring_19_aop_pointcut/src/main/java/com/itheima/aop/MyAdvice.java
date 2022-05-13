package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP切入点表达式
 *  *：  【单个】独立的任意符号，可以独立出现，也可以作为前缀或者后缀的匹配符出现
 *      execution(public * com.shf.*.UserService.find*(*))
 *      匹配com.shf包下的任意包中的UserService类或接口中所有find开头的带有一个参数的方法
 *
 *  ..： 【多个】连续的任意符号，可以独立出现，常用于简化包名与参数的书写
 *      execution(public User com..UserService.findById(..))
 *      匹配com包下的任意包中的UserService类或接口中所有名称为findById的方法
 *
 *  +：  专用与匹配【子类】类型
 *      execution(* *..*Service+.*(..))
 *      任意业务层接口
 *
 *
 *  描述切入点通常描述接口，而不描述实现类
 *  访问控制修饰符针对开发均采用public描述（可省略访问控制修饰符描述）
 *  返回值类型对应增删改类使用精准类型加速匹配，对于查询类使用*通赔快速描述
 *  包名书写尽量不使用...匹配，效率过低，通常*做单个包描述匹配，或精确匹配
 *  接口名 / 类名书写名称与模块相关的采用*匹配，例如UserService书写成*Service，绑定业务层接口名
 *  方法名书写以动词进行精确匹配，名词采用*匹配，例如getById书写成getBy*，selectAll书写成selectAll
 *  参数规则较为复杂，根据业务方法灵活调整
 *  通常不使用异常作为匹配规则
 */

@Component
@Aspect
public class MyAdvice {
    //切入点表达式：
//    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
//    @Pointcut("execution(void com.itheima.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update(*))")    //no
//    @Pointcut("execution(void com.*.*.*.update())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* *..*e(..))")
//    @Pointcut("execution(void com..*())")
//    @Pointcut("execution(* com.itheima.*.*Service.find*(..))")
    //执行com.itheima包下的任意包下的名称以Service结尾的类或接口中的save方法，参数任意，返回值任意
    @Pointcut("execution(* com.itheima.*.*Service.save(..))")
    private void pt(){}

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
