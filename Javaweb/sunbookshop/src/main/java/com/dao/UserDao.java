package com.dao;

import com.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:14
 * @注释:用户接口
 */
public interface UserDao {
    /**
     * 查询用户总数据
     *
     * @return 返回用户总数
     */
    int selectUserByCount();

    /**
     * 查询用户列表
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @return 返回用户列表
     */
    List<User> selectUserAll(int begin, int pageSize);

    /**
     * 通过用户名查询用户信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param user     传入用户名
     * @return 返回用户列表
     */
    List<User> selectUserByName(int begin, int pageSize, User user);

    /**
     * 通过省份序号和城市序号查询用户信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param user     传入省份序号和城市序号
     * @return 返回用户列表
     */
    List<User> selectUserByProvince_city(int begin, int pageSize, User user);

    /**
     * 通过电话号码查询用户信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param user     传入电话号码
     * @return 返回用户列表
     */
    List<User> selectUserByPhone(int begin, int pageSize, User user);

    /**
     * 通过电子邮箱查询用户信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param user     传入电子邮箱
     * @return 返回用户列表
     */
    List<User> selectUserByEmail(int begin, int pageSize, User user);

    /**
     * 新增用户信息
     *
     * @param user 传入用户对象
     * @return 返回受影响的行数
     */
    int insertUser(User user);

    /**
     * 通过用户序号删除用户信息
     *
     * @param user 传入用户序号
     * @return 返回受影响的行数
     */
    int deleteUserById(User user);

    /**
     * 通过用户序号更新用户信息
     *
     * @param user 传入用户序号和用户信息
     * @return 返回受影响的行数
     */
    int updateUserById(User user);

    /**
     * 通过用户序号重置用户密码
     *
     * @param user 传入用户序号
     * @return 返回受影响行数
     */
    int reUserById(User user);
}
