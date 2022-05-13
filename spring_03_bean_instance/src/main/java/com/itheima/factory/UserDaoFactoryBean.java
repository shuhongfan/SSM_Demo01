package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;
//FactoryBean创建对象
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    /**
     * 得到Bean是否是单例的
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 得到的Bean的类型
     * @return
     */
    public Class<?> getObjectType() {
        return UserDao.class;
    }

}
