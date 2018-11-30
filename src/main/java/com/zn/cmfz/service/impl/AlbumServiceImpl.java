package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.AlbummDao;
import com.zn.cmfz.entity.Album;
import com.zn.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbummDao albumDao;

    @Override
    public List<Album> selectAll() {
        return albumDao.selectAll();
    }

    @Override
    public boolean insert(String title, Integer count, Integer score, String author, String broadCast, String brief, String coverImg) {
        try {
            albumDao.insert(title, count, score, author, broadCast, brief, coverImg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
