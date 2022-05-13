package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的配置类
 */
@Configuration
@ComponentScan({"com.itheima"})
//@PropertySource加载properties配置文件
// 多文件使用数组格式，不允许使用通配符
@PropertySource({"jdbc.properties"})
public class SpringConfig {
}
