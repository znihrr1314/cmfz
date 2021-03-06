package com.zn.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private String title;
    private String iconCls;
    private int parentId;
    private String url;
    private List<Menu> menuList;
}
