package com.ccssoft.controller;

import com.ccssoft.base.result.Results;
import com.ccssoft.model.Role;
import com.ccssoft.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("${role}")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @GetMapping("/all")
    public Results<Role> getAll () {
        log.info("RoleController.getAll()");
        return iRoleService.getAllRoles();
    }
}
