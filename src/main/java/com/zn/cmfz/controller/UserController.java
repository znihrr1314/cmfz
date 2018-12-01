package com.zn.cmfz.controller;

import com.zn.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userCount")
    public @ResponseBody
    Map userCount() {
        return userService.getCount();
    }

}
