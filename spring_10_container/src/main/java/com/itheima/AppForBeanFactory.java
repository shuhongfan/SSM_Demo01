package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//初始化BeanFactory
public class AppForBeanFactory {
    public static void main(String[] args) {
        /**
         * BeanFactory创建的对象，所有的bean均为延迟加载
         *
         * BeanFactory是Ioc容器的顶层接口，初始化BeanFactory对象时，加载的bean都延迟加载
         * ApplicationContext接口是spring容器的核心接口，初始化时bean立即加载
         * ApplicationContext接口提供基础的bean操作相关方法，通过其他接口扩展其功能
         * ApplicationContext接口常用初始化类
         *      ClassPathXMLApplicationContext
         *      FileSystemXMLApplicationContext
         */
        Resource resources = new ClassPathResource("applicationContext.xml");
        BeanFactory bf = new XmlBeanFactory(resources);
        BookDao bookDao = bf.getBean(BookDao.class);
        bookDao.save();
    }
}
