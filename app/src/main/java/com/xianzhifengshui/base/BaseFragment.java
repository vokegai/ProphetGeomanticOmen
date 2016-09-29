package com.xianzhifengshui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.xianzhifengshui.utils.SPUtils;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/29.
 * 描述: 自定义Fragment基类
 */
public class BaseFragment extends Fragment {
    protected String TAG;
    protected BaseActivity activity;
    protected SPUtils sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        activity = (BaseActivity) getActivity();
        sp = activity.sp;
    }

    protected void showToast(String text){
        activity.showToast(text);
    }

    protected void showWaiting(){
        activity.showWaiting();
    }

    protected void closeWait(){
        activity.closeWait();
    }

    protected void log(Object... objects){
        activity.log(objects);
    }

    protected void logJson(String json){
        activity.logJson(json);
    }
}
