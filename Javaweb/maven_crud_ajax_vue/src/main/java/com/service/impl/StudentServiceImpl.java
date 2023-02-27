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
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> list() {
        return studentDao.selectAll();
    }

    @Override
    public boolean delStudentById(Student student) {
        return studentDao.deleteByid(student) > 0;
    }

    @Override
    public boolean putStudent(Student student) {
        return studentDao.insertStudent(student) > 0;
    }

    @Override
    public boolean upStudent(Student student) {
        return studentDao.updateStudent(student) > 0;
    }

    @Override
    public Student getStudentById(Student student) {
        return studentDao.selectStudentById(student);
    }

    @Override
    public boolean status(Student student) {
        return studentDao.updateStatus(student) > 0;
    }
}
