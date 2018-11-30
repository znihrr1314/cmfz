package com.zn.cmfz.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class ViewPager {
    private int id;
    private String title;
    private String imgPath;
    private String desc;
    private String status;
    private Date date;
}
