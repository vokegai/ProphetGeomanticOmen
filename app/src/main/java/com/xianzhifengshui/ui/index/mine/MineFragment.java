package com.xianzhifengshui.ui.index.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xianzhifengshui.R;
import com.xianzhifengshui.base.BaseFragment;
import com.xianzhifengshui.ui.login.LoginActivity;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/10.
 * 描述: 个人中心页
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    /*======= 控件声明区 =======*/
    private RelativeLayout loginBtn;
    private RelativeLayout myMastBtn;
    private RelativeLayout myLectureBtn;
    private RelativeLayout myTopicBtn;
    private RelativeLayout becomeMasterBtn;
    private RelativeLayout helpBtn;
    private RelativeLayout settingBtn;
    /*=========================*/

    @Override
    protected void initViews() {
        loginBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_login);
        myMastBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_master);
        myLectureBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_lecture);
        myTopicBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_topic);
        becomeMasterBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_become_master);
        helpBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_help);
        settingBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_setting);
        loginBtn.setOnClickListener(this);
        myMastBtn.setOnClickListener(this);
        myLectureBtn.setOnClickListener(this);
        myTopicBtn.setOnClickListener(this);
        becomeMasterBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected boolean isNeedToolbar() {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mine_login:
                LoginActivity.launcher(activity);
                break;
        }
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        toolbar.setTitle(R.string.text_index_mine_tab);
    }
}
