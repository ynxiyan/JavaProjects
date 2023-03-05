package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.BasicDao;
import com.dao.impl.UserDaoImpl;
import com.model.City;
import com.model.Page;
import com.model.Province;
import com.model.User;
import com.service.UserService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:31
 * @注释:实现逻辑判断的用户接口
 */
public class UserServiceImpl extends BasicDao implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    /**
     * 处理条件查询后的数据条数及用户列表
     *
     * @param list 传入需要处理的用户列表
     * @return 返回处理后用户列表
     */
    public Page<User> aggregate(List<User> list) {
        //计算数据总数
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getCount();
        }
        return new Page(count, list);
    }

    @Override
    public Page<User> list(int pageSize, int currentPage) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //获取分页后的数据
        List<User> list = userDao.selectUserAll(begin, pageSize);
        //获取数据总数
        int count = userDao.selectUserByCount();
        return new Page<>(count, list);
    }

    @Override
    public List<Province> getProvince() {
        return userDao.selectByProvince();
    }

    @Override
    public List<City> getCity(Province province) {
        return userDao.selectByCity(province);
    }

    @Override
    public Page<User> getUserByName(int pageSize, int currentPage, User user) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(userDao.selectUserByName(begin, pageSize, user));
    }

    @Override
    public Page<User> getUserByProvince_city(int pageSize, int currentPage, User user) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(userDao.selectUserByProvince_city(begin, pageSize, user));
    }

    @Override
    public Page<User> getUserByPhone(int pageSize, int currentPage, User user) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(userDao.selectUserByPhone(begin, pageSize, user));
    }

    @Override
    public Page<User> getUserByEmail(int pageSize, int currentPage, User user) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(userDao.selectUserByEmail(begin, pageSize, user));
    }

    @Override
    public boolean addUser(User user) {
        return userDao.insertUser(user) > 0;
    }

    @Override
    public boolean delUserById(User user) {
        return userDao.deleteUserById(user) > 0;
    }

    @Override
    public boolean upUserById(User user) {
        return userDao.updateUserById(user) > 0;
    }

    @Override
    public boolean reUserById(User user) {
        return userDao.reUserById(user) > 0;
    }
}
