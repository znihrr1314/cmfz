package com.zn.cmfz.service;

import com.zn.cmfz.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> selectAll();

    public boolean insert(String title, Integer count, Integer score, String author, String broadCast, String brief, String coverImg);
}
