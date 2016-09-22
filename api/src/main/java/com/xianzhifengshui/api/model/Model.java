package com.xianzhifengshui.api.model;

import java.io.Serializable;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/13.
 * 描述: 示例模型
 */
public class Model implements Serializable{

    private static final long serialVersionUID = -8145998523054809227L;
    private String bizCode;

    private String id;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
