package com.xianzhifengshui.api;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;
import com.xianzhifengshui.api.net.HttpEngine;

import java.lang.reflect.Type;
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
        params.put("id", id);
        Type type = new TypeToken<Model>(){}.getType();
        HttpEngine.getInstance().get(QUERY_FOR_ONE,params,type,callback);
    }

    @Override
    public void queryForList(ActionCallbackListener<List<Model>> callback) {
        Type type = new TypeToken<List<Model>>(){}.getType();
        HttpEngine.getInstance().get(QUERY_FOR_LIST,null,type,callback);
    }

    @Override
    public void queryForPage(ActionCallbackListener<List<Model>> callback) {
        Type type = new TypeToken<List<Model>>(){}.getType();
        HttpEngine.getInstance().get(QUERY_FOR_PAGE,null,type,callback);
    }
}
