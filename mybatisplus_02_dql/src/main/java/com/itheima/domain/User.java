package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//lombok
@Data
//@TableName("tbl_user")
public class User {
//    @TableId(type = IdType.ASSIGN_UUID)
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false) // select设置属性是否参与查询
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)  // exist 数据库不存在此字段
    private Integer online;
}
