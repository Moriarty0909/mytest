package com.ccssoft.controller;

import com.ccssoft.model.User;
import com.ccssoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("${api}")
public class TurnController {
    @Autowired
    IUserService userService;
    String name;
    @RequestMapping("/getPage")
    public ModelAndView getPage (ModelAndView modelAndView, String pageName,Model model,User user) {
        if (user.getUsername() != null && pageName.equals("index"))
            name = user.getUsername();

        if ("user-add".equals(pageName))
            model.addAttribute(new User());
        if ("welcome".equals(pageName)){
            User user1 = new User();
            user1.setUsername(name);
            model.addAttribute(user1);
        }
        if ("user-edit".equals(pageName)) {
            model.addAttribute(userService.getUserById(user.getId()));
        }
        modelAndView.setViewName(pageName);
        return modelAndView;
    }

}
