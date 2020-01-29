package com.ccssoft.service;

import com.ccssoft.base.result.PageTableRequest;
import com.ccssoft.base.result.Results;
import com.ccssoft.model.User;

import java.util.List;

public interface IUserService {
    Results saveToDb (User user, Integer roleId);
    boolean selectUserPW (String userame, String password);
    List<User> getAllUser(PageTableRequest pageTableRequest);
    Integer countAllUsers();

    Integer getIdByUsername(String username);

    User getUserById(int id);
}
