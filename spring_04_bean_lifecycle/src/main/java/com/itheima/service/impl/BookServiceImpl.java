package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * InitializingBean  spring提供创建bean生命周期接口
 * DisposableBean   spring提供销毁bean生命周期接口
 *
 * bean的声明周期：
 *      初始化容器：
 *          1.创建对象（内存分配）
 *          2.执行构造方法
 *          3.执行属性注入（set操作）
 *          4.执行bean初始化方法
*       使用bena
 *          1.执行业务操作
 *      关闭 / 销毁容器
 *          1.执行bean销毁方法
 */
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        System.out.println("set .....");
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    /**
     * bean的销毁
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("service destroy");
    }

    /**
     * 在属性设置之后完成加载
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
