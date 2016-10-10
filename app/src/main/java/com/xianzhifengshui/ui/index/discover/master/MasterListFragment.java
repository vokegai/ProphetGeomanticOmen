package com.xianzhifengshui.ui.index.discover.master;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xianzhifengshui.R;
import com.xianzhifengshui.base.BaseFragment;
import com.xianzhifengshui.widget.pull2refresh.PullToRefreshBase;
import com.xianzhifengshui.widget.pull2refresh.PullToRefreshRecyclerView;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/10.
 * 描述: 大师列表页
 */
public class MasterListFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<RecyclerView>, View.OnClickListener {

    private final int INDEX_HOT = 0;
    private final int INDEX_LOCAL = 1;
    private final int INDEX_ALL = 2;

    /*======= 控件声明区 =======*/
    PullToRefreshRecyclerView pullToRefreshRecyclerView;
    RecyclerView recyclerView;
    TextView hotBtn;
    TextView localBtn;
    TextView allBtn;
    /*=========================*/
    @Override
    protected void initViews() {
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView = pullToRefreshRecyclerView.getRefreshableView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pullToRefreshRecyclerView.setOnRefreshListener(this);
        hotBtn = (TextView) rootView.findViewById(R.id.btn_master_list_hot);
        localBtn = (TextView) rootView.findViewById(R.id.btn_master_list_local);
        allBtn = (TextView) rootView.findViewById(R.id.btn_master_list_all);
        hotBtn.setOnClickListener(this);
        localBtn.setOnClickListener(this);
        allBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_master_list;
    }

    @Override
    protected boolean isNeedToolbar() {
        return false;
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_master_list_hot:
                //切换到热门
                setSelected(INDEX_HOT);
                break;
            case R.id.btn_master_list_local:
                //切换到本地
                setSelected(INDEX_LOCAL);
                break;
            case R.id.btn_master_list_all:
                //切换到全部
                setSelected(INDEX_ALL);
                break;
            default:
                break;
        }

    }

    private void setSelected(int index){
        resetBtn();
        switch (index){
            case INDEX_HOT:

                break;
            case INDEX_LOCAL:

                break;
            case INDEX_ALL:

                break;
            default:
                break;
        }
    }

    private void resetBtn() {
        hotBtn.setSelected(false);
        localBtn.setSelected(false);
        allBtn.setSelected(false);
    }
}
