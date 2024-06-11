package com.star;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.dao.UserDao;
import com.star.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getAllTest(){
        System.out.println(userDao.selectList(null));


//        qw.eq("id", 2);
//        System.out.println(userDao.selectList(qw));

        /*LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        User user = new User();
        user.setAge(40);

        qw.lt(user.getAge() != null, User::getAge, user.getAge());
        System.out.println(userDao.selectList(qw));*/


        /*QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("age, count(*) as count, tel, pwd");
        qw.groupBy("age");
        System.out.println(userDao.selectMaps(qw));*/
    }

    @Test
    public void deleteTest(){
        /*List<Long> ids = new ArrayList<>();
        ids.add(1736326768962953218L);
        ids.add(1736328611994640386L);
        userDao.deleteBatchIds(ids);*/

        userDao.deleteById(1);
    }

    @Test
    public void saveTest(){
        User user = new User();
        user.setName("猪八戒");
        user.setPassword("12134");
        user.setAge(45);
        user.setTel("123545641");
        userDao.insert(user);
    }

    @Test
    public void getByPageTest(){
        IPage page = new Page(1, 2);
        userDao.selectPage(page, null);
        System.out.println("total:" + page.getTotal());
        System.out.println("current:" + page.getCurrent());
        System.out.println("pages:" + page.getPages());
        System.out.println("size:" + page.getSize());
        System.out.println("data:" + page.getRecords());
    }

    @Test
    public void updateTest(){
        /*User user = new User();
        user.setId(2L);
        user.setAge(100);
        user.setName("玉皇大帝");
        user.setVersion(1)
        userDao.updateById(user);*/

        User user1 = userDao.selectById(2);
        User user2 = userDao.selectById(2);

        user1.setAge(100);
        userDao.updateById(user1);

        user2.setAge(99);
        userDao.updateById(user2);

    }

}
