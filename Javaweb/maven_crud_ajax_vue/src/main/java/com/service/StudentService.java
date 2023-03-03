package com.service;

import com.model.Page;
import com.model.Student;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:44
 * @注释:学生逻辑接口
 */
public interface StudentService {
    /**
     * 查询学生集合的逻辑
     *
     * @return 返回学生集合
     */
    Page<Student> list(int pageSize, int currentPage);

    /**
     * 删除学生的逻辑
     *
     * @param student 传入学生id
     * @return 返回执行结果
     */
    boolean delStudentById(Student student);

    /**
     * 添加学生的逻辑
     *
     * @param student 传入学生对象参数
     * @return 返回执行结果
     */
    boolean putStudent(Student student);

    /**
     * 修改学生信息的逻辑
     *
     * @param student 传入学生对象的参数
     * @return 返回执行结果
     */
    boolean upStudent(Student student);

    /**
     * 通过姓名和年级查询学生信息的逻辑
     *
     * @param student 传入学生id
     * @return 返回学生信息
     */
    Student getStudentByNameAndGrade(Student student);

    /**
     * 修改学生状态的逻辑
     *
     * @param student 传入学生状态
     * @return 返回执行结果
     */
    boolean status(Student student);
}
