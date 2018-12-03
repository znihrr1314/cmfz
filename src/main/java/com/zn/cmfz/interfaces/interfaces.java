package com.zn.cmfz.interfaces;

import com.zn.cmfz.entity.ErrorDTO;
import com.zn.cmfz.entity.User;
import com.zn.cmfz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class interfaces {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private ViewService viewService;

    @RequestMapping("/appLogin")
    public @ResponseBody
    Object login(String username, String password) {
        if (username != null) {
            User user = userService.selectOne(username);
            if (password.equals(user.getPassword())) {
                return user;
            } else {
                return new ErrorDTO("101", "密码错误");
            }
        } else {
            return new ErrorDTO("102", "您账号为空");
        }
    }
}
