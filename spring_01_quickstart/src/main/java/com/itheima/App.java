package com.itheima;

import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
