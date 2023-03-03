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
    public List<Student> selectAll(int begin, int pageSize) {
        String sql = "select id,stu_name,grade_name,age,address,ordered,statues from student limit ?,?";
        return selectList(Student.class, sql, begin, pageSize);
    }

    @Override
    public int selectByCount() {
        String sql = "select count(1) from student";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public int deleteByid(Student student) {
        String sql = "delete from student where id=?";
        return update(sql, student.getId());
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student(stu_name,grade_name,age,address,ordered,statues) values(?,?,?,?,?,?)";
        return update(sql, student.getStu_name(), student.getGrade_name(), student.getAge(), student.getAddress(), student.getOrdered(), student.getStatues());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set stu_name=?,grade_name=?,age=?,address=?,ordered=? where id=?";
        return update(sql, student.getStu_name(), student.getGrade_name(), student.getAge(), student.getAddress(), student.getOrdered(), student.getId());
    }

    @Override
    public Student selectStudentByNameAndGrade(Student student) {
        String sql = "select id,stu_name,grade_name,age,address,ordered,statues from student where stu_name=? and grade_name=?";
        return selectOne(Student.class, sql, student.getStu_name(), student.getGrade_name());
    }

    @Override
    public int updateStatus(Student student) {
        String sql = "update student set statues=? where id=?";
        return update(sql, student.getStatues(), student.getId());
    }
}
