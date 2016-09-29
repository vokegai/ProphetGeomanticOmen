package com.xianzhifengshui.api;

import java.io.Serializable;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/29.
 * 描述: 通用数据模型
 */
public class Data<T> implements Serializable {
    private static final long serialVersionUID = -2109574557259720322L;
    private int totalCount; //总条数
    private int pageSize;   //每页显示数量
    private T list ;  //数组对象
    private T object ;      //单个对象
    private int pageNum;    //总页数

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public T getObject() {
        return (T)object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Data{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", object=" + object +
                ", pageNum=" + pageNum +
                '}';
    }
}