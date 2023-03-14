package com.springmvc_demo.dao;

import com.springmvc_demo.model.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 14:09
 * @注释:
 */
public interface UserDao {
    @Insert("insert into tbl_user(name,age)values(#{name},#{age})")
    public void save(User user);
}
