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
        void showOne(String content);
        void showList(String content);
        void showListForPage(String content);
    }

    interface  Presenter extends IPresenter{
        void getOne(String id);

        void getList();

        void getListForPage();
    }
}
