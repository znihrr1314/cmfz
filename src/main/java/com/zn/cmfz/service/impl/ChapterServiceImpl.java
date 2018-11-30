package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.ChapterDao;
import com.zn.cmfz.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public boolean addChapter(String title, Double size, String duration, String downPath, int pid) {
        try {
            chapterDao.insert(title, size, duration, downPath, pid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
