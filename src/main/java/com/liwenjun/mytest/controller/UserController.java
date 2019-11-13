package com.liwenjun.mytest.controller;

import com.liwenjun.mytest.model.User;
import com.liwenjun.mytest.service.UserService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping("/getuser")
    public String getUserById(Model model){
        User user = userService.getUserById(5L);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/listuser")
    public String listUsers(Model model){
        List<User> userList = userService.listUsers();
        model.addAttribute("users",userList);
        logger.info("列表》》》》》》"+userList);

        return "index";
    }

}
