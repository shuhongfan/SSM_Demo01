package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public void update(){
        System.out.println("book dao update is running ...");
    }

    public int select() {
        System.out.println("book dao select is running ...");
//        int i = 1/0;
        return 100;
    }
}
