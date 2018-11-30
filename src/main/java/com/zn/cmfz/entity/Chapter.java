package com.zn.cmfz.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Chapter {
    private int id;
    private String title;
    private Double size;
    private String duration;
    private String downPath;
    private Date uploadDate;
}
