package com.dao.impl;

import com.dao.StudentDao;
import com.model.Student;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:42
 * @注释:实现StudentDao的抽象方法
 */
public class StudentDaoImpl extends BasicDao implements StudentDao {
    @Override
    public List<Student> selectAll() {
        String sql = "select id,name,grade,age,address,ordered,status from student";
        return selectList(Student.class, sql);
    }
}
