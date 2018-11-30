package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.ViewDao;
import com.zn.cmfz.entity.ViewPager;
import com.zn.cmfz.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewDao viewDao;

    @Override
    public List<ViewPager> selectAll() {
        return viewDao.selectAll();
    }

    @Override
    public boolean updateStatus(Integer id, String status) {
        try {
            viewDao.updateStatus(id, status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addView(String title, String imgPath, String desc) {
        try {
            viewDao.insert(title, imgPath, desc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeView(int id) {
        try {
            viewDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
