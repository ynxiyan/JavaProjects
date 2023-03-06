package com.dao.impl;

import com.dao.ProvinceAndCityDao;
import com.model.City;
import com.model.Province;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 9:39
 * @注释:实现省份和城市接口
 */
public class ProvinceAndCityDaoImpl extends BasicDao implements ProvinceAndCityDao {
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
}
