package com.zn.cmfz.dao;

import com.zn.cmfz.entity.ViewPager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewDao {
    public List<ViewPager> selectAll();

    public void updateStatus(@Param("id") Integer id, @Param("status") String status);

    public void insert(@Param("title") String title, @Param("imgPath") String imgPath, @Param("desc") String desc);

    public void delete(int id);
}
