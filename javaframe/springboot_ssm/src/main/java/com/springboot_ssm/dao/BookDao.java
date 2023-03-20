package com.springboot_ssm.dao;

import com.springboot_ssm.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: XIYAN
 * @Date: 2023/3/20 16:39
 * @注释:
 */
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id=#{id}")
    Book selectById(Integer id);
}
