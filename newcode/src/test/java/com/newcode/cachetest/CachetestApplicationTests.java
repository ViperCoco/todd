package com.newcode.cachetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CachetestApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private TestUserDao testUserDao;

    @Test
    public void insert() {
        User user= new User();
        user.setUsername("李四");
        testUserDao.save(user);


    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUsername("王五");
        testUserDao.save(user);
    }

    @Test
    @Cacheable(value = "emp" ,key = "targetClass + methodName +#p0")
    public void select() {
        List<User> users = testUserDao.findAll();
        for (User user:users
             ) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void delete() {
        testUserDao.deleteById(1);
    }



}
