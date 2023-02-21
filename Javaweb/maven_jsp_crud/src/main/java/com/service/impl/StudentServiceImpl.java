package com.service.impl;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.model.Student;
import com.service.StudentService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:47
 * @注释:实现StudentService的抽象方法
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> list() {
        return studentDao.selectAll();
    }
}
