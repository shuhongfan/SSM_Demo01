package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AccountService {
    /**
     * 出现这个问题的原因是，Spring的事务只会对 Error异常 和 RuntimeException异常 及
     * 其子类进行事务回顾，其他的异常类型是不会回滚的，对应IOException不符合上述条
     * 件所以不回滚
     * @param out
     * @param in
     * @param money
     * @throws IOException
     */
    //rollback:设置当前事务参与回滚的异常，默认非运行时异常不参与回滚
//    @Transactional(rollbackFor = IOException.class)
    @Transactional
    public void transfer(String out,String in ,Double money) throws IOException;
}
