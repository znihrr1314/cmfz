package com.zn.cmfz.controller;

import com.zn.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public @ResponseBody
    boolean login(String name, String password, String enCode, HttpSession session) {
        String sessionKaptcha = (String) session.getAttribute("kaptcha");
        if (sessionKaptcha.equalsIgnoreCase(enCode)) {
            if (adminService.login(name, password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
