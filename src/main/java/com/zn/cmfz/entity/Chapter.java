package com.zn.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    private int id;
    private String title;
    private Double size;
    private String duration;
    private String downPath;
    private Date uploadDate;
}
