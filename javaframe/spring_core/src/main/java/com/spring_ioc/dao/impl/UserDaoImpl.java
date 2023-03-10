package com.spring_ioc.dao.impl;

import com.spring_ioc.dao.UserDao;

/**
 * @Author: XIYAN
 * @Date: 2023/3/10 14:22
 * @注释:
 */
public class UserDaoImpl implements UserDao {
    private String databaesName;
    private int connectionNum;

    public void setDatabaesName(String databaesName) {
        this.databaesName = databaesName;
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    @Override
    public void sout() {
        System.out.println("UserDao");
    }
}
