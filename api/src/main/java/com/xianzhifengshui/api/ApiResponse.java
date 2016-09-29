package com.xianzhifengshui.api;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: Api响应封装类
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -5437048962915606356L;
    private int statusCode;  //响应吗，100为成功
    private String status;      //返回信息
    private Data<T> data;       //返回数据

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }

    public boolean isSuccess(){
        return statusCode == 100;
    }


}
