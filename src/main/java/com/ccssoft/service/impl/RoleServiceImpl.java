package com.ccssoft.service.impl;

import com.ccssoft.base.result.Results;
import com.ccssoft.dao.RoleDao;
import com.ccssoft.model.Role;
import com.ccssoft.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public Results<Role> getAllRoles() {
        log.info("getAllRoles");
        return Results.success(50,roleDao.getAllRoles());
    }
}
