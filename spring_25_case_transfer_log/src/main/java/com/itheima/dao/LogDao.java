package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {
    @Insert("insert into tbl_log (info,createDate) values(#{info},now())")
    void log(String info);
}
