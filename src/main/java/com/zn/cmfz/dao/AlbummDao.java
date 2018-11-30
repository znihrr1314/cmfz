package com.zn.cmfz.dao;

import com.zn.cmfz.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbummDao {
    public List<Album> selectAll();

    public void insert(@Param("title") String title, @Param("count") Integer count, @Param("score") Integer score, @Param("author") String author, @Param("broadCast") String broadCast, @Param("brief") String brief, @Param("coverImg") String coverImg);
}
