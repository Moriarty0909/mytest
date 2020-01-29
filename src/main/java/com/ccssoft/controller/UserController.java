package com.ccssoft.controller;

import com.ccssoft.base.result.PageTableRequest;
import com.ccssoft.base.result.ResponseCode;
import com.ccssoft.base.result.Results;
import com.ccssoft.dto.UserDto;
import com.ccssoft.model.User;
import com.ccssoft.service.IUserService;
import com.ccssoft.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;


@Slf4j
@RestController
public class UserController {
    @Autowired
    IUserService iUserService;

    /**
     * 判断登录
     * @param username 用户名
     * @param password 密码
     * @return 登录是否成功
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login (String username,String password) {
        if(iUserService.selectUserPW(username,password)) {
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 获取所有的用户信息,以分页的形式
     * @param pageTableRequest 获取的页面信息
     * @return 结果数据实体类
     */
    @GetMapping("/list")
    public Results getAllUser (PageTableRequest pageTableRequest) {
        return Results.success("success", iUserService.countAllUsers().intValue(), iUserService.getAllUser(pageTableRequest));
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Results<User> addUser (UserDto userDto, Integer roleId) {
        if (iUserService.getIdByUsername(userDto.getUsername()) != null){
            return Results.failure(ResponseCode.USERNAME_REPEAT);
        }
        userDto.setStatus(1);
        userDto.setPassword(MD5.getPwd(userDto.getPassword()));
        return iUserService.saveToDb(userDto,roleId);
    }


    String pattern = "yyyy-MM-dd";
    @InitBinder
    private void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat(pattern),true));
    }
}
