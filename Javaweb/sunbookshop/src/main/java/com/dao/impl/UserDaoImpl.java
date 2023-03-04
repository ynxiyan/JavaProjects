package com.dao.impl;

import com.dao.UserDao;
import com.model.City;
import com.model.Province;
import com.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:21
 * @注释:实现用户接口
 */
public class UserDaoImpl extends BasicDao implements UserDao {
    @Override
    public int selectUserByCount() {
        String sql = "select count(1) from user";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public List<Province> selectByProvince() {
        String sql = "select id,name as 'province' from province";
        return selectList(Province.class, sql);
    }

    @Override
    public List<City> selectByCity(Province province) {
        String sql = "select city.id,city.name as 'city' from province,city where province_id=province.id and province.id=?";
        return selectList(City.class, sql, province.getId());
    }

    @Override
    public List<User> selectUserAll(int begin, int pageSize) {
        String sql = "select user.id,user.name,password,sex,phone,email,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address from user,province,city where user.province_id=province.id and user.city_id=city.id limit ?,?";
        return selectList(User.class, sql, begin, pageSize);
    }

    @Override
    public List<User> selectUserByName(int begin, int pageSize, User user) {
        String sql = "select user.id,user.name,password,sex,phone,email,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address,count(1) as 'count' from user,province,city where user.name like ? and user.province_id=province.id and user.city_id=city.id group by user.id limit ?,?";
        return selectList(User.class, sql, "%" + user.getName() + "%", begin, pageSize);
    }

    @Override
    public List<User> selectUserByProvince_city(int begin, int pageSize, User user) {
        String sql = "select user.id,user.name,password,sex,phone,email,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address,count(1) as 'count' from user,province,city where user.province_id=? and city_id=? and user.province_id=province.id and user.city_id=city.id group by user.id limit ?,?";
        return selectList(User.class, sql, user.getProvince(), user.getCity(), begin, pageSize);
    }

    @Override
    public List<User> selectUserByPhone(int begin, int pageSize, User user) {
        String sql = "select user.id,user.name,password,sex,phone,email,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address,count(1) as 'count' from user,province,city where phone=? and user.province_id=province.id and user.city_id=city.id group by user.id limit ?,?";
        return selectList(User.class, sql, user.getPhone(), begin, pageSize);
    }

    @Override
    public List<User> selectUserByEmail(int begin, int pageSize, User user) {
        String sql = "select user.id,user.name,password,sex,phone,email,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address,count(1) as 'count' from user,province,city where email=? and user.province_id=province.id and user.city_id=city.id group by user.id limit ?,?";
        return selectList(User.class, sql, user.getEmail(), begin, pageSize);
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user(name,password,sex,phone,email,province_id,city_id,address) values(?,'0000',?,?,?,?,?,?);";
        return update(sql, user.getName(), user.getSex(), user.getPhone(), user.getEmail(), user.getProvince(), user.getCity(), user.getAddress());
    }

    @Override
    public int deleteUserById(User user) {
        String sql = "delete from user where id=?";
        return update(sql, user.getId());
    }

    @Override
    public int updateUserById(User user) {
        String sql = "update user set user.name=?,sex=?,phone=?,email=?,user.province_id=?,user.city_id=?,address=? where user.id=?";
        return update(sql, user.getName(), user.getSex(), user.getPhone(), user.getEmail(), user.getProvince(), user.getCity(), user.getAddress(), user.getId());
    }
}
