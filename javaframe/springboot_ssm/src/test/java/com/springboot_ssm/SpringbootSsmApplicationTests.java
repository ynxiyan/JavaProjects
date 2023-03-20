package com.springboot_ssm;

import com.springboot_ssm.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSsmApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void testById() {
        System.out.println(bookDao.selectById(1));
    }
}
