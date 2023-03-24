package com.ynxiyan;

import com.ynxiyan.config.SpringConfig;
import com.ynxiyan.dao.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 10:12
 * @注释:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class testDao {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetBookAll() {
        System.out.println(bookDao.selectAll());
    }
}
