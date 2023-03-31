package com.ynxiyan.springboot_mybatis_demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ynxiyan.springboot_mybatis_demo.mapper.UserMapper;
import com.ynxiyan.springboot_mybatis_demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    //当前页码
    int pageNum = 1;
    //当前页记录数量
    int pageSize = 1;

    @Test
    void getUserAll() {
        //存储开始页码和显示数量
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectUserAll());
        System.out.println(pageInfo);
    }

    @Test
    void login() {
        String userName = "张山";
        String password = "123";
        User user = userMapper.selectUserByUserNameAndPassword(userName, password);
        System.out.println(user);
    }

    @Test
    void getUserSwith() {
//        //存储开始页码和显示数量
//        PageHelper.startPage(pageNum, pageSize);
//        User user = new User();
//        //user.setUserName("王五");
//        user.setGender("男");
//        //user.setAddr("昆明");
//        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectUserSwith(user));
//        System.out.println(pageInfo);
    }

    @Test
    void getUserCondition() {
        //存储开始页码和显示数量
        PageHelper.startPage(pageNum, pageSize);
        User user = new User();
        //user.setUserName("王五");
        user.setGender("男");
        user.setAddr("昆明");
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectUserCondition(user));
        System.out.println(pageInfo);
    }

    @Test
    void register() {
        String userName = "测试";
        String password = "12345";
        int falg = userMapper.insertUserByUserNameAndPassword(userName, password);
        System.out.println(falg);
    }

    @Test
    void postUser() {
        User user = new User();
        user.setUserName("cs");
        //user.setAddr("昆明");
        user.setGender("女");
        int falg = userMapper.insertUser(user);
        System.out.println(falg);
    }

    @Test
    void change() {
        String userName = "cs";
        String password = "123";
        int falg = userMapper.updateUserByUserName(userName, password);
        System.out.println(falg);
    }

    @Test
    void putUser() {
        User user = new User();
        user.setId(6);
        //user.setUserName("xiugai");
        //user.setGender("男");
        user.setAddr("长沙");
        int falg = userMapper.updateUser(user);
        System.out.println(falg);
    }

    @Test
    void deleteUserById() {
        int id = 5;
        int falg = userMapper.deleteUserById(id);
        System.out.println(falg);
    }

    @Test
    void deleteUserByIds() {
        List<User> userList = userMapper.selectUserAll();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            list.add(userList.get(i).getId());
        }
        int falg = userMapper.deleteUserByids(list);
        System.out.println(falg);
    }
}
