package com.xianzhifengshui.api;


import java.util.ArrayList;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: Api响应封装类
 */
public class ApiResponse<T> {
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

    public class Data<N>{
        private int totalCount; //总条数
        private int pageSize;   //每页显示数量
        private ArrayList<N> list ;        //数组对象
        private N object ;      //单个对象
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

        public ArrayList<N> getList() {
            return list;
        }

        public void setList(ArrayList<N> list) {
            this.list = list;
        }

        public N getObject() {
            return object;
        }

        public void setObject(N object) {
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

    public boolean isSuccess(){
        return statusCode == 100;
    }


}
