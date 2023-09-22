package com.star.test;

import com.star.domain.User;
import com.star.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = sqlSession.selectList("test.findAll");
        List<User> users = userMapper.findAll();
        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}
