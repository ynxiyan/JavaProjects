package com;


import com.mapper.BrandMapper;
import com.model.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XIYAN
 * @Date: 2023/3/9 10:02
 * @注释:mapper代理开发
 */
public class MybatisTest3 {
    @Test
    public void selectAll() throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper接口的单例对象并执行方法
        System.out.println(sqlSession.getMapper(BrandMapper.class).selectAll());
        //释放资源
        sqlSession.close();
    }

    @Test
    public void selectById() throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper接口的单例对象并执行方法
        System.out.println(sqlSession.getMapper(BrandMapper.class).selectById(1));
        //释放资源
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper接口的单例对象并执行方法
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
//        System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(status, companyName, brandName));
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(brand));
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
        System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(map));
        //释放资源
        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取BrandMapper接口的单例对象并执行方法
        String brandName = "苹果";
        String companyName = "苹果";
        int ordered = 100;
        String description = "xdjsbfgjkse";
        int status = 0;
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        System.out.println(brand.getId());
//        //提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取BrandMapper接口的单例对象并执行方法
        int id = 5;
        String brandName = "苹果";
        String companyName = "apper";
        int ordered = 100;
        String description = "dfgggggggggg";
        int status = 0;
        Brand brand = new Brand();
        brand.setId(id);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.update(brand));
//        //提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
