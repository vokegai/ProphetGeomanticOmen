package com.xianzhifengshui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xianzhifengshui.R;
import com.xianzhifengshui.api.Api;
import com.xianzhifengshui.api.ApiImpl;
import com.xianzhifengshui.api.ApiResponse;
import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;
import com.xianzhifengshui.base.BaseActivity;
import com.xianzhifengshui.utils.AppUtils;
import com.xianzhifengshui.utils.KLog;
import com.xianzhifengshui.widget.dialog.NormalAlertDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: demo
 */
public class MainActivity extends BaseActivity {
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
                    showWaiting();
            }

            @Override
            public void onSuccess(ApiResponse.Data data) {
//                Model model = (Model) data.getObject();
                log(data.getObject().getClass().getSimpleName());
//                log(model.toString());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        closeWaiting();
                    }
                },3000);
//                closeWaiting();
            }

            @Override
            public void onFailure(int errorEvent, String message) {

            }
        });


    }
}
