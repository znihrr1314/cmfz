package com.zn.cmfz.controller;

import com.zn.cmfz.entity.Menu;
import com.zn.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("getAllMenu")
    public @ResponseBody
    List getAllMenu() {
        List<Menu> list = menuService.getAllMenu();
        return list;
    }


}
