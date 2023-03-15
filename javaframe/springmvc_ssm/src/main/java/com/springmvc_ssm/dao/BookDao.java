package com.springmvc_ssm.dao;

import com.springmvc_ssm.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 15:15
 * @注释:图书数据层接口
 */
public interface BookDao {
    /**
     * 新增图书信息
     *
     * @param book 传入图书对象
     */
    //mapper自动代理（插入）
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    void save(Book book);

    /**
     * 通过图书序号更新图书信息
     *
     * @param book 传入图书序号
     */
    //mapper自动代理（更新）
    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    void update(Book book);

    /**
     * 通过图书序号删除图书信息
     *
     * @param id 传入图书序号
     */
    //mapper自动代理（删除）
    @Delete("delete from tbl_book where id = #{id}")
    void delete(Integer id);

    /**
     * 通过图书序号查询图书信息
     *
     * @param id 传入图书序号
     * @return 返回图书信息
     */
    //mapper自动代理（查询）
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);

    /**
     * 查询全部图书信息
     *
     * @return 返回图书信息列表
     */
    @Select("select * from tbl_book")
    List<Book> getAll();
}
