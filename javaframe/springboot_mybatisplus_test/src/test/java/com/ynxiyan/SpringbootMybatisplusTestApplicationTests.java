package com.ynxiyan;

import com.ynxiyan.dao.BookDao;
import com.ynxiyan.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusTestApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(15);
        book.setBookName("tugfddd");
        bookDao.updateById(book);
        bookDao.selectList(null).forEach(System.out::println);
    }

}
