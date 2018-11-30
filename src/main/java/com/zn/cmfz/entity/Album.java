package com.zn.cmfz.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Album {
    private int id;
    private String title;
    private String coverImg;
    private int count;
    private int score;
    private String author;
    private String broadCast;
    private String brief;
    private Date publishDate;
    private List<Chapter> children;
}
