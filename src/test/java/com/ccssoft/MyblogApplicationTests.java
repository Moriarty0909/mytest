package com.ccssoft;

import com.ccssoft.dao.UserDao;
import com.ccssoft.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyblogApplicationTests {//单元测试是一个对单一实体（类或方法）的测试。每一项需求至少需要两个单元测试用例，一个正检验，一个负检验
    @Autowired
    User user;
    @Resource
    UserDao userDao;

    @Test
    void contextLoads() {

    }

    @Test
    public void setInto () {
        User user = new User();
        user.setUsername("罗志祥");
        user.setPassword("567890");
        user.setCreateTime(new Date());
        userDao.saveUser(user);
    }
}
