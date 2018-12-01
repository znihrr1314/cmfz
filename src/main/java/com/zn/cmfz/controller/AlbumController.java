package com.zn.cmfz.controller;

import com.zn.cmfz.service.AlbumService;
import com.zn.cmfz.service.ChapterService;
import com.zn.cmfz.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/allAlbum")
    public @ResponseBody
    List allAlbum() {
        return albumService.selectAll();
    }

    @RequestMapping("/addAlbum")
    public @ResponseBody
    boolean addAlbum(String title, Integer count, Integer score, String author, String broadCast, String brief, MultipartFile pic, HttpServletRequest request) throws IOException {
        String fileName = pic.getOriginalFilename();
        fileName = new Date().getTime() + "_" + fileName;
        String realPath = request.getRealPath("img");
        pic.transferTo(new File(realPath + "\\" + fileName));
        return albumService.insert(title, count, score, author, broadCast, brief, fileName);
    }

    @RequestMapping("/addchapter")
    public @ResponseBody
    boolean addChapter(String title, int pid, MultipartFile muc, HttpServletRequest request) throws IOException {
        //获取文件存储路径
        String realPath = request.getSession().getServletContext().getRealPath("/");  //webapp当前项目的路径
        File file = new File(realPath + "/upload");
        if (!file.exists()) {
            file.mkdir();
        }
        //获取文件新名字
        String fileName = FilenameUtils.getExtension(muc.getOriginalFilename());
        fileName = new Date().getTime() + "." + fileName;
        muc.transferTo(new File(file.getAbsolutePath(), fileName));
        //获取文件时长
        int size = FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + fileName));
        String duration = size / 60 + ":" + size % 60;
        //文件大小
        long t = muc.getSize();
        double l = t / 1024.0 / 1024.0;
        boolean result = chapterService.addChapter(title, l, duration, fileName, pid);
        return result;
    }

    @RequestMapping("/download")
    public void download(String downPath, String title, HttpServletRequest request, HttpServletResponse response) {
        //获取文件存储路径
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");  //webapp当前项目的路径
        //获取文件位置
        String path = uploadPath + "/" + downPath;
        File file = new File(path);
        //获取文件名
        String s = title + "." + "mp3";
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
