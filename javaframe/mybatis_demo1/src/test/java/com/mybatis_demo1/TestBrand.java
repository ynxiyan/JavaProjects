package com.mybatis_demo1;

import com.mybatis_demo1.mapper.BrandMapper;
import com.mybatis_demo1.model.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/30 15:19
 * @注释:
 */
public class TestBrand {
    //加载mybatis的核心配置文件，获取SqlSessionFactory
    String resource = "mybatis_config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取sqlSession对象，用于执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //获取UserMapper接口的单例对象
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    public TestBrand() throws IOException {
    }

    @Test
    public void getBrandAll() {
        List<Brand> brandList = brandMapper.selectBrandAll();
        System.out.println(brandList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void getBrandById() {
        Brand brand = brandMapper.selectBrandById(1);
        System.out.println(brand);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void getBrandByCondition() {
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setBrandName("%华为%");
        List<Brand> brandList = brandMapper.selectBrandByCondition(brand);
        System.out.println(brandList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void getBrandBySwitch() {
        Brand brand = new Brand();
        brand.setStatus(1);
        List<Brand> brandList = brandMapper.selectBrandBySwitch(brand);
        System.out.println(brandList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void postBrand() {
        Brand brand = new Brand();
        brand.setBrandName("参数");
        brand.setCompanyName("qq");
        brand.setOrdered(4);
        brand.setStatus(0);
        int insertBrand = brandMapper.insertBrand(brand);
        System.out.println(insertBrand + "\t" + brand.getId());
        //释放资源
        sqlSession.close();
    }

    @Test
    public void putBrandById() {
        Brand brand = new Brand();
        brand.setId(8);
        brand.setCompanyName("xx");
        int updateBrand = brandMapper.updateBrandById(brand);
        System.out.println(updateBrand);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void deleteBrandById() {
        int deleteBrandById = brandMapper.deleteBrandById(8);
        System.out.println(deleteBrandById);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void deleteBrandByIds() {
        int[] ids = {4, 5};
        int deleteBrandByIds = brandMapper.deleteBrandByIds(ids);
        System.out.println(deleteBrandByIds);
        //释放资源
        sqlSession.close();
    }
}
