package com.xianzhifengshui.ui.test;

import com.xianzhifengshui.api.BaseListModel;
import com.xianzhifengshui.api.model.User;
import com.xianzhifengshui.api.net.ActionCallbackListener;
import com.xianzhifengshui.base.BasePresenter;
import com.xianzhifengshui.utils.KLog;

import java.util.ArrayList;

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
    public void login(String userName, String password) {
        api.userLogin(userName, password, new ActionCallbackListener<User>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                if (!view.isActive()){
                    return;
                }
                view.showWaiting();
            }

            @Override
            public void onSuccess(User data) {
                view.showLoginSuccess(data.toString());
                view.closeWait();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                view.showLoginFalure(message);
                view.showWaiting();
            }
        });
    }

    @Override
    public void getMasterList(int pageNum, int pageSize) {
        api.masterList(pageNum, pageSize, new ActionCallbackListener<BaseListModel<ArrayList<User>>>() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                if (view.isActive())
                view.showWaiting();
            }

            @Override
            public void onSuccess(BaseListModel<ArrayList<User>> data) {
                view.showGetMasterListSuccess(data.toString());
                view.closeWait();
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                view.showWaiting();
                view.showTip(message);
            }
        });
    }
}
