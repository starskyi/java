package com.star.test;

import com.star.domain.Brand;
import com.star.domain.User;
import com.star.mapper.BrandMapper;
import com.star.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {





    @Test
    public void testFindAll() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取ObjectMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.findAll();
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testFindById() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取ObjectMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        String brandName = "";
        String companyName = "%公司%";
        List<Brand> brands = brandMapper.selectByCondition(brandName, companyName);
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取UserMapper接口的代理对象
        User user = new User();
        user.setUsername("王维");
        user.setPassword("李清照");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.add(user);
        System.out.println(user.getId());

        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取UserMapper接口的代理对象
        User user = new User();
        user.setId(6);
        user.setUsername("王维");
        user.setPassword("6666666");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.update(user);

        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        //1.加载mybatis核心加载文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //3.1 获取UserMapper接口的代理对象
        int[] ids = {4, 5, 6};
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteByIds(ids);

        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

}
