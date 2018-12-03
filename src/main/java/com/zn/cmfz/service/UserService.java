package com.zn.cmfz.service;

import com.zn.cmfz.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public Map getCount();

    public Map countBoy();

    public Map countGirl();

    public User selectOne(String username);

    public List<User> allUser();
}
