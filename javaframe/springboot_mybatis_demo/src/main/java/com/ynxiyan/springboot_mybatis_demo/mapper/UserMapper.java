package com.ynxiyan.springboot_mybatis_demo.mapper;

import com.ynxiyan.springboot_mybatis_demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/30 19:49
 * @注释:
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return 返回分页后的用户列表
     */
    @Select("select id, username as 'userName', gender, addr from tb_user")
    List<User> selectUserAll();

    /**
     * 通过用户名和密码查询用户信息（登录）
     *
     * @param userName 传入用户名
     * @param password 传入密码
     * @return 返回用户信息
     */
    @Select("select * from tb_user where username = #{userName} and password = #{password}")
    User selectUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 单条件查询用户信息
     *
     * @param user 传入需要查询的用户信息
     * @return 返回分页后用户列表
     */
    List<User> selectUserSwith(User user);

    /**
     * 多条件查询用户信息
     *
     * @param user 传入需要查询的用户信息
     * @return 返回分页后的用户列表
     */
    List<User> selectUserCondition(User user);

    /**
     * 新增用户信息（注册）
     *
     * @param userName 传入用户名
     * @param password 传入密码
     * @return 返回受影响的行数
     */
    @Insert("insert into tb_user (username, password) values (#{userName},#{password})")
    int insertUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 新增用户信息
     *
     * @param user 传入用户信息
     * @return 返回受影响的行数
     */
    int insertUser(User user);

    /**
     * 通过用户名修改密码
     *
     * @param userName 传入用户名
     * @param password 传入新密码
     * @return 返回受影响的行数
     */
    @Update("update tb_user set password = #{password} where username = #{userName}")
    int updateUserByUserName(@Param("userName") String userName, @Param("password") String password);

    /**
     * 修改用户信息
     *
     * @param user 传入需要修改的用户信息
     * @return 返回受影响的行数
     */
    int updateUser(User user);

    /**
     * 通过id删除用户信息
     *
     * @param id 传入id
     * @return 返回受影响的行数
     */
    @Delete("delete from tb_user where id = #{id}")
    int deleteUserById(@Param("id") int id);

    /**
     * 批量删除用户信息
     *
     * @param ids 传入id列表
     * @return
     */
    int deleteUserByids(@Param("ids") List<Integer> ids);
}
