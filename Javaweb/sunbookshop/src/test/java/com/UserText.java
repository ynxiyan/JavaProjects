package com;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.User;
import org.junit.Test;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 19:22
 * @注释:
 */
public class UserText {
    @Test
    public void user() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setPhone("18262383173");
        System.out.println(userDao.selectUserByPhone(0, 5, user));

    }
}
