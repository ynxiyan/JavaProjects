package com.ynxiyan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ynxiyan.model.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 11:02
 * @注释:
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
