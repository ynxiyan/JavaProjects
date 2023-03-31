package com.ynxiyan;

import com.ynxiyan.dao.BookDao;
import com.ynxiyan.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisTestApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
//        bookDao.selectBookAll().forEach(System.out::println);
        Book book = new Book();
        book.setId(15);
        book.setBookName("2345");
        System.out.println(bookDao.upadteById(book));
    }

}
