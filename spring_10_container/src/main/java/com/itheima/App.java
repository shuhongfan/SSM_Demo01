package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /**
         * 创建容器
         */
        //1.加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从文件系统下加载配置文件
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\workspace\\spring\\spring_10_container\\src\\main\\resources\\applicationContext.xml");

        /**
         * 获取bean的方式
         */
//        方式一：使用bean名称获取
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");

//        方式二：使用bean名称获取并指定类型
//        BookDao bookDao = ctx.getBean("bookDao",BookDao.class);

//        方式三：使用bean类型获取
        BookDao bookDao = ctx.getBean(BookDao.class);

        bookDao.save();
    }
}
