package com.springboot_mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        //User user = new User(null, "test", "1234", 12, "1564456776");
        //System.out.println(userDao.insert(user));
    }

    @Test
    void testDeleteById() {
        User user = new User();
        System.out.println(userDao.deleteById(1638009402685128705l));
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

    @Test
    void testSelectAllPage() {
        IPage page = new Page(1, 4);
        userDao.selectPage(page, null);
        System.out.println("当前页码为：" + page.getCurrent() + "，每页显示：" + page.getSize() + "条，共：" + page.getPages() + "页");
        System.out.println("总计：" + page.getTotal() + "条");
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void testSelect() {
//        //字符串
//        QueryWrapper queryWrapper = new QueryWrapper();
//        //条件：年龄小于13
//        queryWrapper.lt("age", 13);
//        System.out.println(userDao.selectList(queryWrapper));
//        //lambda
//        QueryWrapper<User> queryWrapper = new QueryWrapper();
//        //条件：年龄小于13
//        queryWrapper.lambda().lt(User::getAge,13);
//        System.out.println(userDao.selectList(queryWrapper));
//        //lambda(LambdaQueryWrapper)
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
//        //条件：年龄小于13
//        lambdaQueryWrapper.lt(User::getAge,13);
//        System.out.println(userDao.selectList(lambdaQueryWrapper));
    }
}
