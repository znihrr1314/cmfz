package com.zn.cmfz.service;

import com.zn.cmfz.entity.ViewPager;

import java.util.List;

public interface ViewService {
    public List<ViewPager> selectAll();

    public boolean updateStatus(Integer id, String status);

    public boolean addView(String title, String imgPath, String desc);

    public boolean removeView(int id);
}
