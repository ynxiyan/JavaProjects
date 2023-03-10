package com.spring_ioc.factory;

import com.spring_ioc.dao.UserDao;
import com.spring_ioc.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: XIYAN
 * @Date: 2023/3/10 15:41
 * @注释:
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    //获取bean的实例对象类型
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    //设置bean实例的是否为非单例
    @Override
    public boolean isSingleton() {
        //false:表示单例
        //true：表示非单例
        return false;
    }
}
