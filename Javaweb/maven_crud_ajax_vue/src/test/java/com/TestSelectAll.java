package com;

import com.service.StudentService;
import com.service.impl.StudentServiceImpl;
import org.junit.Test;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:50
 * @注释:
 */
public class TestSelectAll {
    @Test
    public void testSelectAll() {
        StudentService studentService = new StudentServiceImpl();
        //System.out.println(studentService.list());
    }
}
