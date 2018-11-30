package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.MenuDao;
import com.zn.cmfz.entity.Menu;
import com.zn.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.selectAll();
    }
}
