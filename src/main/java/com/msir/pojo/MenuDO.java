package com.msir.pojo;

import java.util.Date;

/**
 * Created by Fantasy on 2017/5/26.
 */
public class MenuDO {
    private int id;
    private Date gmtCreate;
    private Date gmtModified;
    private String menuTitle;
    private String menuUrl;
    private String menuTarget;
    private int menuSubId;
    private String menuVisible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public int getMenuSubId() {
        return menuSubId;
    }

    public void setMenuSubId(int menuSubId) {
        this.menuSubId = menuSubId;
    }

    public String getMenuVisible() {
        return menuVisible;
    }

    public void setMenuVisible(String menuVisible) {
        this.menuVisible = menuVisible;
    }
}
