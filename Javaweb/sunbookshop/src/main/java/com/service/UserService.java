package com.service;

import com.model.City;
import com.model.Page;
import com.model.Province;
import com.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:28
 * @注释:逻辑判断的用户接口
 */
public interface UserService {
    /**
     * 逻辑判断用户列表
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @return 返回用户列表
     */
    Page<User> list(int pageSize, int currentPage);

    /**
     * 逻辑判断省份列表
     *
     * @return 返回省份列表
     */
    List<Province> getProvince();

    /**
     * 逻辑判断城市列表
     *
     * @param province 传入省份序号
     * @return 返回城市列表
     */
    List<City> getCity(Province province);

    /**
     * 逻辑判断用户名查询用户信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @param user        传入用户名
     * @return 返回用户列表
     */

    Page<User> getUserByName(int pageSize, int currentPage, User user);

    /**
     * 逻辑判断省份序号和城市序号查询用户信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param user        传入省份序号和城市序号
     * @return 返回用户列表
     */
    Page<User> getUserByProvince_city(int pageSize, int currentPage, User user);

    /**
     * 逻辑判断电话号码查询用户信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param user        传入电话号码
     * @return 返回用户列表
     */
    Page<User> getUserByPhone(int pageSize, int currentPage, User user);

    /**
     * 逻辑判断电子邮箱查询用户信息
     *
     * @param pageSize    传入每页页数
     * @param currentPage 传入当前页
     * @param user        传入电子邮箱
     * @return 返回用户列表
     */
    Page<User> getUserByEmail(int pageSize, int currentPage, User user);

    /**
     * 逻辑判断新增用户信息
     *
     * @param user 传入用户对象
     * @return 返回执行结果
     */
    boolean addUser(User user);

    /**
     * 逻辑判断用户序号删除用户信息
     *
     * @param user 传入用户序号
     * @return 返回执行结果
     */
    boolean delUserById(User user);

    /**
     * 逻辑判断用户序号更新用户信息
     *
     * @param user
     * @return
     */
    boolean upUserById(User user);

    /**
     * 逻辑判断用户序号重置用户密码
     *
     * @param user
     * @return
     */
    boolean reUserById(User user);
}
