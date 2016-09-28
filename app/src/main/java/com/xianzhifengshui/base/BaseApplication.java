package com.xianzhifengshui.base;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xianzhifengshui.utils.KLog;
import com.xianzhifengshui.utils.XImageLoader;

/**
 * 作者: 陈冠希
 * 日期: 2016/9/27.
 * 描述: 自定义应用入口
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化XImageLoader
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        XImageLoader.getInstance().init(configuration);
        KLog.init(AppConfig.isDebug);

    }
}
