package com.ccssoft.service.impl;

import com.ccssoft.base.result.PageTableRequest;
import com.ccssoft.base.result.ResponseCode;
import com.ccssoft.base.result.Results;
import com.ccssoft.dao.RoleUserDao;
import com.ccssoft.dao.UserDao;
import com.ccssoft.model.RoleUser;
import com.ccssoft.model.User;
import com.ccssoft.service.IUserService;
import com.ccssoft.util.MD5;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@Service
/**
 * 可以作用于接口、接口方法、类以及类方法上。
 * 当作用于类上时，该类的所有public方法将都具有该类型的事务属性。
 * 类内部方法调用本类内部的其他方法并不会引起事务行为
 */
@Transactional(isolation = READ_COMMITTED)
/*
 属性信息：
 name，多个事务管理器可以指定选择哪个。propagation，事务的传播行为，默认是REQUIRED。isolation，事务的隔离度，默认是DEFAULT。timeout，默认-1，超时未完成自动回滚事务。
 */
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleUserDao roleUserDao;
    @Override
    public Results saveToDb(User user, Integer roleId) {

        if (roleId != null ) {
            userDao.saveUser(user);
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId());
            roleUserDao.saveToDB(roleUser);

            return Results.success();
        }
        return Results.failure(ResponseCode.USERNAME_REPEAT);
    }

    @Override
    public boolean selectUserPW(String userame, String password) {
        User user = userDao.getUser(userame);
        try{
            user.getUsername();
        } catch (NullPointerException e){
            return false;
        }
        if (user.getPassword().equals(MD5.getPwd(password))) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser(PageTableRequest pageTableRequest) {
        pageTableRequest.countOffset();
        List<User> list = userDao.getAllUserByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit());
        return list;
    }

    @Override
    public Integer countAllUsers() {
        return userDao.countAllUsers();
    }

    @Override
    public Integer getIdByUsername(String username) {
        return userDao.selectIdByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }

}
