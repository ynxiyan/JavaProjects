package com.mapper;

import com.model.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Author: XIYAN
 * @Date: 2023/3/9 15:23
 * @注释:
 */
public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询（散装参数）
     *
     * @param status      传入状态
     * @param companyName 传入企业名称
     * @param brandName   传入产品名称
     * @return 返回商品列表
     */
    //List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    /**
     * 条件查询（对象参数）
     *
     * @param brand 传入品牌对象
     * @return 返回商品列表
     */
    //List<Brand> selectByCondition(Brand brand);

    /**
     * 条件查询（Map集合）
     *
     * @param map 传入Map的键
     * @return 返回商品列表
     */
    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Brand brand);
    void add(Brand brand);
    int update(Brand brand);
}
