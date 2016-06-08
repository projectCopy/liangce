package com.maixianda.copy.liangce.mxdlibrary.core.Event;

import android.os.Looper;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Administrator on 2016/6/7.
 * 说明:           事件中心
 *                 实现 注册事件,释放事件,发送事件
 * 创建人:         maixianda
 * 创建时间:       2016/6/7 10:55
 */
public class EventHub {
    /**
     * 主线程中的事件总线
     */
    private static final Bus bus = new Bus(ThreadEnforcer.MAIN);

    /**
     * 注册事件
     * @param object 要注册的application
     */
    public void registerEvent(Object object)
    {
        bus.register(object);
    }

    /**
     * 释放事件
     * @param Object 要释放的application
     */
    public void unRegisterEvent(Object Object)
    {
        bus.unregister(Object);
    }

    public void post(Object object)
    {
        if (null == object)
        {
            return;
        }

        if (Looper.myLooper() == Looper.getMainLooper())
        {
            bus.post(object);
        }
        else
        {
            // TODO: 2016/6/7 11:14 在UI线程上面post事件
        }
    }
}
