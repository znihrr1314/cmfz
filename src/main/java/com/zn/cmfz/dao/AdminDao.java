package com.zn.cmfz.dao;

import com.zn.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    public Admin selectOne(@Param("name") String name, @Param("password") String password);
}
