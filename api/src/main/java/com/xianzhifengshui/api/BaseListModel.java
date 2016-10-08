package com.xianzhifengshui.api;

import java.io.Serializable;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/8.
 * 描述: 列表模型基类
 */
public class BaseListModel<T> implements Serializable{
    private static final long serialVersionUID = 6303838440204152855L;
    private int totalCount; //总条数
    private int pageSize;   //每页显示数量
    private int pageNum;    //总页数
    private T list;         //数组对象

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BaseListModel{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", list=" + list +
                '}';
    }
}
