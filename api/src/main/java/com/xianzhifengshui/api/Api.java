package com.xianzhifengshui.api;

import com.xianzhifengshui.api.model.Model;
import com.xianzhifengshui.api.net.ActionCallbackListener;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: Api接口
 */
public interface Api {
    String QUERY_FOR_ONE = "queryForOne";   //单个对象

    String QUERY_FOR_LIST = "queryForList"; //列表

    String QUERY_FOR_PAGE = "queryForPage"; //分页列表

    /**
     * 测试请求单个对象
     * @param id 对象id
     * @param callback 回调监听器
     */
    void queryForOne(String id,ActionCallbackListener<Model> callback);

    /**
     * 测试请求列表
     * @param callback 回调监听器
     */
    void queryForList(ActionCallbackListener<List<Model>> callback);

    /**
     * 测试请求分页列表
     * @param callback 回调监听器
     */
    void queryForPage(ActionCallbackListener<List<Model>> callback);





}
