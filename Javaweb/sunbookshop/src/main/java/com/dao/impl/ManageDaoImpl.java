package com.dao.impl;

import com.dao.ManageDao;
import com.model.Manage;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 16:57
 * @注释:实现管理员接口
 */
public class ManageDaoImpl extends BasicDao implements ManageDao {
    @Override
    public Manage selectMange(Manage manage) {
        //通过sql查询用户名和密码
        String sql = "select name,password from manage where name=? and password=?";
        return selectOne(Manage.class, sql, manage.getName(), manage.getPassword());
    }

    @Override
    public int updateByName(Manage manage) {
        String sql = "update manage set password=? where name=?";
        return update(sql, manage.getPass(), manage.getName());
    }
}
