package com.xianzhifengshui.ui.test;

import com.xianzhifengshui.base.IPresenter;
import com.xianzhifengshui.base.IView;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/29.
 * 描述:
 */
public interface TestContract {
    interface View extends IView<Presenter>{
        void showLoginSuccess(String message);
        void showLoginFalure(String message);
        void showGetMasterListSuccess(String message);
    }

    interface  Presenter extends IPresenter{
        void login(String userName,String password);

        void getMasterList(int pageNum,int pageSize);

    }
}
