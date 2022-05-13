package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP 核心概念
 *  目标对象（Target）：原始功能去掉共性功能对应的类产生的对象，这种对象是无法直接完成最终工作的
 *  代理（proxy）：目标对象无法直接完成工作，需要对其功能进行回填，通过原始对象的代理对象实现
 *
 *  springAOP在运行的时候，最终是【代理对象】在运行
 *  代理对象是对原始对象代理，称为目标对象
 *
 *  如果你的切入点能和造bean的类匹配上，就造代理对象，否则造原始对象
 *
 *  SpringAOP的本质： 动态代理
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.update();

        System.out.println(bookDao);  // com.itheima.dao.impl.BookDaoImpl@673be18f
        System.out.println(bookDao.getClass());  // 代理类 class com.sun.proxy.$Proxy20
    }
}
