package com.zn.cmfz.controller;

import com.zn.cmfz.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping("/allView")
    public @ResponseBody
    List allView() {
        return viewService.selectAll();
    }

    @RequestMapping("/updateStatus")
    public @ResponseBody
    boolean updateStatus(Integer id, String status) {
        boolean result = viewService.updateStatus(id, status);
        return result;
    }

    @RequestMapping("/addView")
    public @ResponseBody
    boolean addView(String title, MultipartFile pic, String desc, HttpServletRequest request) throws IOException {
        String fileName = pic.getOriginalFilename();
        fileName = new Date().getTime() + "_" + fileName;
        String realPath = request.getRealPath("img");
        pic.transferTo(new File(realPath + "\\" + fileName));
        return viewService.addView(title, fileName, desc);
    }

    @RequestMapping("/removeView")
    public @ResponseBody
    boolean removeView(int id, String imgPath, HttpServletRequest request) {
        System.out.println(imgPath);
        String realPath = request.getRealPath("img");
        File file = new File(realPath + "/" + imgPath);
        file.delete();
        return viewService.removeView(id);
    }

}
