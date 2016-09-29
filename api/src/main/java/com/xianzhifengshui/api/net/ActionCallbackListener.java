package com.xianzhifengshui.api.net;

import com.xianzhifengshui.api.ApiResponse;
import com.xianzhifengshui.api.Data;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/12.
 * 描述: Action的处理结果回调监听器
 */
public interface ActionCallbackListener<T> {
    /**
     * 进度变化时调用
     * @param bytesWritten 当前进度
     * @param totalSize 总进度
     */
    void onProgress(long bytesWritten, long totalSize);

    /**
     * 成功时调用
     * @param data 返回的数据
     */
    void onSuccess(Data<T> data);

    /**
     * 失败时调用
     * @param errorEvent 错误码
     * @param message    错误信息
     */
    void onFailure(int errorEvent, String message);


}
