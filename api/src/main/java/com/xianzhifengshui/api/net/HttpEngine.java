package com.xianzhifengshui.api.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.xianzhifengshui.api.ApiResponse;
import com.xianzhifengshui.api.Data;
import com.xianzhifengshui.api.model.Model;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: 引擎处理类
 */
public class HttpEngine {
    public final String HOST = "http://123.56.162.170/demo/";      //服务器主地址
    private static final int JSON_SYNTAX_ERROR = -1;
    private static final String JSON_SYNTAX_INFO = "返回数据格式错误";
    private static AsyncHttpClient client;
    public static HttpEngine instance;

    private HttpEngine(){

    }

    public static HttpEngine getInstance(){
        if (instance == null) {
            instance = new HttpEngine();
        }
        if (client == null) {
            client = new AsyncHttpClient();
            client.setTimeout(3000 * 10);
            client.addHeader("client", "Android");
            client.addHeader("Accept-Encoding", "gzip");
        }
        return instance;
    }

    public  <T>  void  get(String method, final RequestParams params, final Type typeOfClass ,final ActionCallbackListener<T> callback){
        String url = HOST + method;
        client.get(url, params, new TextHttpResponseHandler()  {


            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                callback.onProgress(bytesWritten, totalSize);
            }

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                callback.onFailure(i,throwable.getMessage());
            }

            @Override
            public void onSuccess(int i, Header[] headers, String json) {
                ApiResponse<T> response = json2Obj(json, typeOfClass);
                if (response.isSuccess()){
                        callback.onSuccess(response.getData());
                    }else {
                        callback.onFailure(response.getStatusCode(),response.getStatus());
                    }
            }
        });
    }

    private <T> ApiResponse<T> json2Obj(String json,Type typeOfT) throws JsonSyntaxException {
        Gson gson = new Gson();
        ApiResponse<T> response = new ApiResponse<>();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        if (jsonObject.has("statusCode")){
            response.setStatusCode(jsonObject.get("statusCode").getAsInt());
        }
        if (jsonObject.has("status")){
            response.setStatus(jsonObject.get("status").getAsString());
        }
        if (jsonObject.has("data")){
            String jsonDataStr = jsonObject.get("data").toString();
            Data<T> data = new Data<>();
            JsonObject jsonData = parser.parse(jsonDataStr).getAsJsonObject();
            if (jsonData.has("totalCount")){
                data.setTotalCount(jsonData.get("totalCount").getAsInt());
            }
            if (jsonData.has("pageSize")){
                data.setPageSize(jsonData.get("pageSize").getAsInt());
            }
            if (jsonData.has("pageNum")){
                data.setPageNum(jsonData.get("pageNum").getAsInt());
            }
            if (jsonData.has("object")){
                data.setObject((T) gson.fromJson(jsonData.get("object").toString(),typeOfT));
            }
            if (jsonData.has("list")){
                data.setList((T) new Gson().fromJson(jsonData.get("list").toString(),typeOfT));
            }
            response.setData(data);
        }
        return response;
    }





}
