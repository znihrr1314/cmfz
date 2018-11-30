package com.zn.cmfz.dao;

import org.apache.ibatis.annotations.Param;

public interface ChapterDao {
    public void insert(@Param("title") String title, @Param("size") Double size, @Param("duration") String duration, @Param("downPath") String downPath, @Param("pid") int pid);
}
