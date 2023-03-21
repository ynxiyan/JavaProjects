package com.springboot_mybatisplus;

import com.springboot_mybatisplus.dao.UserDao;
import com.springboot_mybatisplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testInsert() {
        User user = new User(null, "test", "1234", 12, "1564456776");
        System.out.println(userDao.insert(user));
    }

    @Test
    void testDeleteById() {
        User user = new User();
        System.out.println(userDao.deleteById(1638010091989630977l));
    }

    @Test
    void testUpadteById() {
        User user = new User();
        user.setId(1638011119938093058l);
        user.setAge(33);
        System.out.println(userDao.updateById(user));
    }

    @Test
    void testSelectById() {
        User user = new User();
        System.out.println(userDao.selectById(1638011119938093058l));
    }

    @Test
    void testSelectAll() {
        System.out.println(userDao.selectList(null));
    }
}
