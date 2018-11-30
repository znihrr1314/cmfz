package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.AdminDao;
import com.zn.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean login(String name, String password) {
        if (adminDao.selectOne(name, password) != null) {
            return true;
        } else {
            return false;
        }
    }
}
