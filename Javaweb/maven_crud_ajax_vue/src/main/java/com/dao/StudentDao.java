package com.dao;

import com.model.Student;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:38
 * @注释:学生crud接口
 */
public interface StudentDao {
    /**
     * 查询分页数据
     *
     * @return 返回学生集合
     */
    List<Student> selectAll(int begin, int pageSize);

    /**
     * 查询总数据
     *
     * @return 返回总数
     */
    int selectByCount();

    /**
     * 通过id删除学生
     *
     * @param student 传入学生id
     * @return 返回受影响的行数
     */
    int deleteByid(Student student);

    /**
     * 添加学生
     *
     * @param student 传入学生对象参数
     * @return 返回受影响的行数
     */
    int insertStudent(Student student);

    /**
     * 通过id更新学生信息
     *
     * @param student 传入学生对象参数
     * @return 返回受影响的行数
     */
    int updateStudent(Student student);

    /**
     * 通过姓名和年级查询学生信息
     *
     * @param student 传入学生姓名与年级
     * @return 返回学生信息
     */

    Student selectStudentByNameAndGrade(Student student);

    /**
     * 修改学生状态
     *
     * @param student 传入学生状态
     * @return 返回受影响的行数
     */
    int updateStatus(Student student);

}
