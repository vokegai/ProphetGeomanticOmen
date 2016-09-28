package com.xianzhifengshui.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.xianzhifengshui.utils.ConstUtils;
import com.xianzhifengshui.utils.KLog;
import com.xianzhifengshui.utils.SPUtils;
import com.xianzhifengshui.utils.ToastUtils;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/28.
 * 描述: 自定义Activity基类
 */
public class BaseActivity extends AppCompatActivity {
    protected String TAG;
    public BaseApplication app;
    public SPUtils sp;
    public boolean isActive;
    private boolean couldDoubleBackExit;
    private boolean pressedOnce;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        TAG = getClass().getSimpleName();
        sp = new SPUtils(this,AppConfig.SP_NAME);
        app = (BaseApplication) this.getApplication();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isActive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }

    @Override
    public void onBackPressed() {
        if (!couldDoubleBackExit){
            super.onBackPressed();
        }else {
            if (pressedOnce){
                System.exit(0);
                return;
            }
            pressedOnce = true;
            showToast("再按一次退出程序");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pressedOnce = false;
                }
            }, ConstUtils.SEC*2);
        }
    }

    /**
     * 设置是否可以双击退出
     * @param couldDoubleBackExit true 开启双击退出
     */
    public void setCouldDoubleBackExit(boolean couldDoubleBackExit) {
        this.couldDoubleBackExit = couldDoubleBackExit;
    }

    /**
     * 显示Toast
     * @param text 内容
     */
    public void showToast(String text){
        ToastUtils.showToast(this,text);
    }

    /**
     * 打印普通log日志
     * @param text 日志内容
     */
    public void log(String text){
        KLog.d(TAG, text);
    }

    /**
     * 打印Jsonlog日志
     * @param json json字符串
     */
    public void logJson(String json){
        KLog.json(TAG,json);
    }
}
