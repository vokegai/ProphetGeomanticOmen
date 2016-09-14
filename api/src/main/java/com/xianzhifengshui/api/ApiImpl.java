package com.xianzhifengshui.api;

import android.text.TextUtils;

import com.loopj.android.http.RequestParams;
import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;
import com.xianzhifengshui.api.net.HttpEngine;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: Api实现类
 */
public class ApiImpl implements Api {
    public final int PARAM_NULL = -2;


    @Override
    public void queryForOne(String id, ActionCallbackListener<Model> callback) {
        if(TextUtils.isEmpty(id)){
            if (callback != null) {
                callback.onFailure(PARAM_NULL,"id不能为空");
            }
            return;
        }
        RequestParams params = new RequestParams();
        params.put("id",id);
        HttpEngine.getInstance().get(QUERY_FOR_ONE,params,callback);
    }

    @Override
    public void queryForList(ActionCallbackListener<List<Model>> callback) {
        HttpEngine.getInstance().get(QUERY_FOR_LIST,null,callback);
    }

    @Override
    public void queryForPage(ActionCallbackListener<List<Model>> callback) {
        HttpEngine.getInstance().get(QUERY_FOR_PAGE,null,callback);
    }
}
