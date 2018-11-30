package com.zn.cmfz.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {
    @Autowired
    private Producer producer;

    @RequestMapping("/getKaptcha")
    public void getKaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        //1.生成文本内容
        String text = producer.createText();
        //把文本内容放在session中
        session.setAttribute("kaptcha", text);
        //2.把生成的文本内容放在一张图片中
        BufferedImage image = producer.createImage(text);
        //通过图片工具类，把图片响应到输出流
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
