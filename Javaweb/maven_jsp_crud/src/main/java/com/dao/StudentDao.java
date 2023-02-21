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
     * 查询全部学生
     *
     * @return 返回学生集合
     */
    List<Student> selectAll();

}
