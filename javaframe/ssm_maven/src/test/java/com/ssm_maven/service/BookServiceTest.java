package com.ssm_maven.service;

import com.ssm_maven.config.SpringConfig;
import com.ssm_maven.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 16:08
 * @注释:图书业务层接口测试
 */
//指定当前类为Spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//加载Spring测试配置
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    //自动装配Service
    @Autowired
    private BookService bookService;

    //测试新增图书信息
    @Test
    public void TestSave() {
        Book book = new Book();
        book.setName("111");
        book.setType("123");
        book.setDescription("123");
        System.out.println(bookService.save(book));
    }

    //测试通过图书序号更新图书信息
    @Test
    public void TestUpdate() {
        Book book = new Book();
        book.setName("222");
        book.setId(14);
        System.out.println(bookService.update(book));
    }

    //测试通过图书序号删除图书信息
    @Test
    public void TestDelete() {
        System.out.println(bookService.delete(13));
    }

    //测试通过图书序号查询图书信息
    @Test
    public void TestGetById() {
        System.out.println(bookService.getById(1));
    }

    //测试查询全部图书信息列表
    @Test
    public void TestGetByAll() {
        System.out.println(bookService.getAll());
    }
}
