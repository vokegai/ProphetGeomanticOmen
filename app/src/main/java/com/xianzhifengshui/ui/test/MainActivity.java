package com.xianzhifengshui.ui.test;

import android.os.Bundle;
import android.widget.TextView;

import com.xianzhifengshui.R;
import com.xianzhifengshui.base.AppConfig;
import com.xianzhifengshui.base.BaseActivity;
import com.xianzhifengshui.utils.KLog;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: demo
 */
public class MainActivity extends BaseActivity implements TestContract.View{

    TestContract.Presenter presenter;

    TextView queryForOne;
    TextView queryForList;
    TextView queryForPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        presenter = new TestPresenter(this);
        presenter.getMasterList(1, AppConfig.PAGE_SIZE);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isNeedToolbar() {
        return false;
    }


    @Override
    protected void initData() {

    }


    @Override
    public void setPresenter(TestContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }




    @Override
    public void showTip(String text) {
        this.showToast(text);
    }

    @Override
    public void showLoginSuccess(String message) {
        KLog.d(TAG,message);
    }

    @Override
    public void showLoginFalure(String message) {
        KLog.d(TAG,message);
    }

    @Override
    public void showGetMasterListSuccess(String message) {
        KLog.d(TAG,message);
    }
}
