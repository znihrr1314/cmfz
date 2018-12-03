package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.UserDao;
import com.zn.cmfz.entity.User;
import com.zn.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map getCount() {
        int[] days = {7, 14, 21};
        int[] counts = new int[3];
        Map map = new HashMap();
        for (int i = 0; i < days.length; i++) {
            int count = userDao.getCount(days[i]);
            counts[i] = count;
        }
        map.put("counts", counts);
        map.put("intervals", new String[]{"近一周用户", "近两周用户", "近三周用户"});
        return map;
    }

    @Override
    public Map countBoy() {
        Map map = new HashMap();
        map.put("count", userDao.countSex("男"));
        return map;
    }

    @Override
    public Map countGirl() {
        Map map = new HashMap();
        map.put("count", userDao.countSex("女"));
        return map;
    }

    @Override
    public User selectOne(String username) {
        return userDao.selectOne(username);
    }

    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }
}
