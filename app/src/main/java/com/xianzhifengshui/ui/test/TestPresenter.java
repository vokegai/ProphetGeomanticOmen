package com.xianzhifengshui.ui.test;

import com.xianzhifengshui.api.Data;
import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;
import com.xianzhifengshui.base.BasePresenter;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/29.
 * 描述:
 */
public class TestPresenter extends BasePresenter implements TestContract.Presenter {
    TestContract.View view;

    public TestPresenter(TestContract.View view) {
        super();
        this.view = view;
        this.view.setPresenter(this);

    }

    @Override
    public void getOne(String id) {

        api.queryForOne(id, new ActionCallbackListener<Model>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                if (view.isActive())
                    view.showWaitingDialog();
            }

            @Override
            public void onSuccess(Data<Model> data) {
                view.showOne(data.toString());
//                view.closeWaitingDialog();
                getList();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                if (!view.isActive())
                    return;
                view.showTip(message);
                view.closeWaitingDialog();
            }
        });
    }

    @Override
    public void getList() {
        api.queryForList(new ActionCallbackListener<List<Model>>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {

            }

            @Override
            public void onSuccess(Data<List<Model>> data) {
                view.showList(data.toString());
                getListForPage();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                if (!view.isActive()){
                    return;
                }
                view.closeWaitingDialog();
                view.showTip(message);
            }
        });
    }

    @Override
    public void getListForPage() {
        api.queryForPage(new ActionCallbackListener<List<Model>>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {

            }

            @Override
            public void onSuccess(Data<List<Model>> data) {
                view.showListForPage(data.toString());
                view.closeWaitingDialog();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                if (!view.isActive()){
                    return;
                }
                view.closeWaitingDialog();
                view.showTip(message);
            }
        });

    }
}
