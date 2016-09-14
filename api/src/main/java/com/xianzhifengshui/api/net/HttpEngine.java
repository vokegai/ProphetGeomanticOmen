package com.xianzhifengshui.api.net;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.xianzhifengshui.api.ApiResponse;

import java.lang.reflect.Type;

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

    public  <T> void get(String method, RequestParams params, final ActionCallbackListener<T> callback){
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
            public void onSuccess(int i, Header[] headers, String s) {
                Type type = new TypeToken<ApiResponse<T>>(){}.getType();
                try {
                    ApiResponse<T> response = json2Obj(s,type);
                    if (response.isSuccess()){
                        callback.onSuccess(response.getData());
                    }else {
                        callback.onFailure(response.getStatusCode(),response.getStatus());
                    }

                }catch (JsonSyntaxException e){
                    callback.onFailure(JSON_SYNTAX_ERROR,JSON_SYNTAX_INFO);
                }
            }
        });
    }

    private <T> ApiResponse<T> json2Obj(String json,Type typeOfT) throws JsonSyntaxException {
        Gson gson = new Gson();
        return gson.fromJson(json,typeOfT);
    }





}
