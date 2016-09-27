package com.xianzhifengshui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.xianzhifengshui.R;
import com.xianzhifengshui.api.Api;
import com.xianzhifengshui.api.ApiImpl;
import com.xianzhifengshui.api.ApiResponse;
import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: demo
 */
public class MainActivity extends FragmentActivity {
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView queryForOne = (TextView) findViewById(R.id.text_main_queryForOne);
        final TextView queryForList = (TextView) findViewById(R.id.text_main_queryForList);
        final TextView queryForPage = (TextView) findViewById(R.id.text_main_queryForPage);
        Api api = new ApiImpl();
        api.queryForOne("2", new ActionCallbackListener<Model>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                queryForOne.setText("onProgress:bytesWritten=" + bytesWritten + "totalSize=" + totalSize);
            }

            @Override
            public void onSuccess(ApiResponse.Data data) {
                Model model = (Model) data.getObject();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                queryForOne.setText("onFailure:errorEvent=" + errorEvent + "message=" + message);
            }
        });
        api.queryForList(new ActionCallbackListener<List<Model>>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                queryForList.setText("onProgress:bytesWritten=" + bytesWritten + "totalSize=" + totalSize);
            }

            @Override
            public void onSuccess(ApiResponse.Data data) {
                ArrayList<Model> list = data.getList();
                queryForList.setText(list.toString());
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                queryForList.setText("onFailure:errorEvent=" + errorEvent + "message=" + message);
            }
        });
        api.queryForPage(new ActionCallbackListener<List<Model>>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                queryForPage.setText("onProgress:bytesWritten=" + bytesWritten + "totalSize=" + totalSize);
            }

            @Override
            public void onSuccess(ApiResponse.Data data) {
                queryForPage.setText("onSuccess:" + data.toString());
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                queryForPage.setText("onFailure:errorEvent=" + errorEvent + "message=" + message);
            }
        });
    }
}
