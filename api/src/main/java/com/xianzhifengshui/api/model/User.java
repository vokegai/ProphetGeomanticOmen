package com.xianzhifengshui.api.model;

import java.io.Serializable;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/8.
 * 描述: 用户模型
 */
public class User implements Serializable{
    private static final long serialVersionUID = 9043766419151746508L;

    private int id; //用户id（无实际含义）
    private String username; //登录成功的用户名
    private String bizCode; //用户编号（唯一性）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bizCode='" + bizCode + '\'' +
                '}';
    }
}
