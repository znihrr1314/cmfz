package com.zn.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zn.cmfz.entity.User;
import com.zn.cmfz.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    @RequestMapping("/countBoy")
    public @ResponseBody
    Map countBoy() {
        return userService.countBoy();
    }

    @RequestMapping("/countGirl")
    public @ResponseBody
    Map countGirl() {
        return userService.countGirl();
    }

    @RequestMapping("/allUser")
    public @ResponseBody
    List allUser() {
        return userService.allUser();
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;fileName=allUser.xls");
        try {
            List<User> list = new ArrayList<>();
            List<User> lists = userService.allUser();
            for (int i = 0; i < lists.size(); i++) {
                list.add(lists.get(i));
            }
            /*File savefile = new File("E:/excel/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }*/

            ExportParams exort = new ExportParams("所有用户", "用户表");
            Workbook workbook = ExcelExportUtil.exportExcel(exort, User.class, list);

            //FileOutputStream fos = new FileOutputStream("C:/Users/z9568/Desktop/allUser.xls");
            //workbook.write(fos);

            workbook.write(response.getOutputStream());
            //return true;
        } catch (IOException e) {
            e.printStackTrace();
            //return false;
        }
    }
}
