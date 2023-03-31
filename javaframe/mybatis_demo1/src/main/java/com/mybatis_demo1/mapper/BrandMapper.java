package com.mybatis_demo1.mapper;

import com.mybatis_demo1.model.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/30 15:06
 * @注释:
 */
public interface BrandMapper {
    /**
     * 查询所有品牌信息
     *
     * @return 返回品牌信息列表
     */
    List<Brand> selectBrandAll();

    /**
     * 通过id查询品牌信息
     *
     * @param id 传入品牌id
     * @return 返回品牌信息
     */
    Brand selectBrandById(@Param("id") int id);

    /**
     * 多条件查询品牌信息
     *
     * @param brand 传入需要查询的品牌信息
     * @return 返回品牌信息列表
     */
    List<Brand> selectBrandByCondition(Brand brand);

    /**
     * 单条件查询品牌信息
     *
     * @param brand 传入需要查询的品牌信息
     * @return 返回品牌信息列表
     */
    List<Brand> selectBrandBySwitch(Brand brand);

    /**
     * 新增品牌信息
     *
     * @param brand 传入新增的品牌信息
     * @return 返回受影响的行数
     */
    int insertBrand(Brand brand);

    /**
     * 修改品牌信息
     *
     * @param brand 传入需要修改的品牌信息
     * @return 返回受影响的行数
     */
    int updateBrandById(Brand brand);

    /**
     * 通过品牌id删除品牌信息
     *
     * @param id 传入品牌id
     * @return 返回受影响的行数
     */
    int deleteBrandById(@Param("id") int id);

    /**
     * 批量删除品牌信息
     *
     * @param ids 传入品牌id数组
     * @return 返回受影响的行数
     */
    int deleteBrandByIds(@Param("ids") int[] ids);
}
