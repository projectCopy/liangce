package com.maixianda.copy.liangce.mxdlibrary;

import android.app.Application;

/**
 * Created by Administrator on 2016/6/7.
 * 说明: 应用程序基类
 *       单例类
 *       应用启动注册eventbus
 *
 * 创建人:maixianda
 * 创建时间:2016/6/7 10:15
 */
public class BaseApp extends Application {

    /**
     * 唯一静态实例
     */
    private static BaseApp sBaseApp = null;

    private BaseApp() {
        sBaseApp = this;
    }

    /**
     * 获取唯一实例
     * @return 返回唯一静态实例sBaseApp {@link BaseApp}
     * @see #sBaseApp
     */
    public static <T extends BaseApp> T me()
    {
        if(null == sBaseApp)
        {
            sBaseApp = new BaseApp();
        }
        return (T)sBaseApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: 2016/6/7 10:43 eventbus注册,eventbus反注册,打印消息的类注册
    }
}
