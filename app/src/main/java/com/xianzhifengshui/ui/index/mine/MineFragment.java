package com.xianzhifengshui.ui.index.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xianzhifengshui.R;
import com.xianzhifengshui.base.BaseFragment;
import com.xianzhifengshui.ui.login.LoginActivity;
import com.xianzhifengshui.widget.CircleImageView;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/10.
 * 描述: 个人中心页
 */
public class MineFragment extends BaseFragment implements View.OnClickListener,MineContract.View {

    /*======= 控件声明区 =======*/
    private RelativeLayout loginBtn;
    private RelativeLayout myMastBtn;
    private RelativeLayout myLectureBtn;
    private RelativeLayout myTopicBtn;
    private RelativeLayout becomeMasterBtn;
    private RelativeLayout helpBtn;
    private RelativeLayout settingBtn;
    private CircleImageView avatarImage;
    private TextView nickNameText;
    private TextView userNameText;
    /*=========================*/

    private MineContract.Presenter presenter;

    public void onEventMainThread(boolean isLogin){
        presenter.checkIsLoginUpdateUI(sp);
    }

    @Override
    protected void initViews() {
        loginBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_login);
        myMastBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_master);
        myLectureBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_lecture);
        myTopicBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_my_topic);
        becomeMasterBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_become_master);
        helpBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_help);
        settingBtn = (RelativeLayout) rootView.findViewById(R.id.btn_mine_setting);
        avatarImage = (CircleImageView) rootView.findViewById(R.id.image_mine_avatar);
        userNameText = (TextView) rootView.findViewById(R.id.text_mine_user_name);
        nickNameText = (TextView) rootView.findViewById(R.id.text_mine_nick_name);
        loginBtn.setOnClickListener(this);
        myMastBtn.setOnClickListener(this);
        myLectureBtn.setOnClickListener(this);
        myTopicBtn.setOnClickListener(this);
        becomeMasterBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        presenter.checkIsLoginUpdateUI(sp);
    }

    @Override
    protected void initData() {
        presenter = new MinePresenter(this);
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
        if (v.getId() == R.id.btn_mine_setting){
            //TODO:跳转到设置页面

        }else{
            presenter.checkIsLoginJump(sp,v.getId());
        }
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        toolbar.setTitle(R.string.text_index_mine_tab);
    }

    @Override
    public void toLoginActivity() {
        LoginActivity.launcher(getContext());
    }

    @Override
    public void showLoginInfo() {
        nickNameText.setText("屎蛋儿");
        userNameText.setText("18631565231");
        avatarImage.setImageResource(R.drawable.pic);
    }

    @Override
    public void showDefaultInfo() {
        nickNameText.setText("点击登录");
        userNameText.setText("登录后更精彩哦~");
        avatarImage.setImageResource(R.drawable.avatar_not_login_icon);
    }

    @Override
    public void jumpToActivity(int id) {
        switch (id){
            case R.id.btn_mine_my_master:
                //TODO:跳转到我的大师页面

                break;
            case R.id.btn_mine_my_lecture:
                //TODO:跳转到我的讲座页面

                break;
            case R.id.btn_mine_my_topic:
                //TODO:跳转到我的话题页面

                break;
            case R.id.btn_mine_become_master:
                //TODO:跳转到成为大师页面

                break;
            case R.id.btn_mine_help:
                //TODO:跳转到帮助反馈页面

                break;
        }
    }

    @Override
    public void setPresenter(MineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void showTip(String text) {
        showToast(text);
    }


}
