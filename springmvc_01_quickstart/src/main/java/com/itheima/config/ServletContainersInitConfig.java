package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//web容器配置类
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    //加载springmvc配置类，产生springmvc容器（本质还是spring容器）

    /**
     * 创建servlet容器时，加载springMVC对应的bean并放入WebApplicationContext对象范围中，
     * 而WebApplicationContext的作用范围为ServletContext范围，即整个web容器范围
     * @return
     */
    protected WebApplicationContext createServletApplicationContext() {
        //初始化WebApplicationContext对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //加载指定配置类
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    //设置由springmvc控制器处理的请求映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 创建Servlet容器时需要加载非springMVC对应的bean
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
