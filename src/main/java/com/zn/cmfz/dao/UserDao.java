package com.zn.cmfz.dao;

import com.zn.cmfz.entity.User;
import com.zn.cmfz.entity.UserDTO;

import java.util.List;

public interface UserDao {
    public int getCount(int days);

    public List<UserDTO> countSex(String sex);

    public User selectOne(String username);

    public List<User> allUser();

}
