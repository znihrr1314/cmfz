package com.zn.cmfz.service.impl;

import com.zn.cmfz.dao.UserDao;
import com.zn.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
}
