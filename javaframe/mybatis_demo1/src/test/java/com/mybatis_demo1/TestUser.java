package com.mybatis_demo1;

import com.mybatis_demo1.mapper.UserMapper;
import com.mybatis_demo1.model.User;
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
 * @Date: 2023/3/30 9:39
 * @注释:
 */
public class TestUser {
    //加载mybatis的核心配置文件，获取SqlSessionFactory
    String resource = "mybatis_config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取sqlSession对象，用于执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取UserMapper接口的单例对象
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    public TestUser() throws IOException {
    }

    @Test
    public void getUserAll() {
        List<User> userList = userMapper.selectUserAll();
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
}
