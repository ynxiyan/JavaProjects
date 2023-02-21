package com.service;

import com.model.Student;

import java.util.List;

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
    List<Student> list();
}
