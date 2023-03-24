package com.ynxiyan.dao;

import com.ynxiyan.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 14:27
 * @注释:
 */
@Mapper
public interface BookDao {
    @Select("select * from books")
    List<Book> selectBookAll();
}
