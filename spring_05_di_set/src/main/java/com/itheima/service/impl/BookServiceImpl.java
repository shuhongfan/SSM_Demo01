package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;
    private UserDao userDao;
    //setter注入需要提供要注入对象的set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //setter注入需要提供要注入对象的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }
}
