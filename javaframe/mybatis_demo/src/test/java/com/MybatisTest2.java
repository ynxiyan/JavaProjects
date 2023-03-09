package com;


import com.mapper.UserMapper;
import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/9 10:02
 * @注释:mapper代理开发
 */
public class MybatisTest2 {
    public static void main(String[] args) throws IOException {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的单例对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
}
