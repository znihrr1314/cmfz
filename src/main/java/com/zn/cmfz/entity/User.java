package com.zn.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("user")
public class User {
    @Excel(name = "用户编号")
    private int id;
    @Excel(name = "用户名")
    private String username;
    @ExcelIgnore
    private String password;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "注册日期", format = "yyyy-MM-dd")
    private Date date;
}
