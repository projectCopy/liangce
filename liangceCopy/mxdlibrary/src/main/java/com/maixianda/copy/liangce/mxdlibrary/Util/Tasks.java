package com.maixianda.copy.liangce.mxdlibrary.Util;


import android.os.Handler;
import android.os.Looper;

import com.maixianda.copy.liangce.mxdlibrary.Util.Log.Logger;
import com.maixianda.copy.liangce.mxdlibrary.Util.Log.LoggerFactory;

/**
 * Created by Administrator on 2016/6/7.
 * 说明:           任务处理工具类
 *                 实现:
 *                       获取主线程                handler handler()
 *                       发送任务到主线程运行      runOnUIThread(Runnable runnable)
 *                 内部类:
 *                       任务适配器                 RunnableAdapter
 * 创建人:         maixianda
 * 创建时间:       2016/6/7 11:19
 */
public class Tasks {

    private Handler mHandler = null;
    private static final Logger LOG = LoggerFactory.getLogger(RunnableAdapter.class);

    /**
     * 获取主线程handler
     * @return 返回主线程的Handler
     */
    public Handler handler()
    {
        if (null == mHandler)
        {
            mHandler = new Handler(Looper.getMainLooper());
        }
        else
        {
            if (mHandler.getLooper() != Looper.getMainLooper())
            {
                mHandler = new Handler(Looper.getMainLooper());
            }
        }
        return mHandler;
    }

    /**
     * 发送一个任务到主线程运行
     * @param runnable 要运行的任务
     */
    public void runOnUIThread(Runnable runnable)
    {
        // TODO: 2016/6/7 11:28 发送一个运行在主线程的任务到主线程
        //handler().post(new)
    }

    /**
     * 任务适配器
     */
    private class RunnableAdapter implements Runnable {

        private Runnable mRunnable = null;

        public RunnableAdapter(Runnable Runnable) {
            this.mRunnable = Runnable;
        }

        @Override
        public void run() {
            // TODO: 2016/6/7 11:35 监控程序运行效率的工具类需要实现下
            try {
                mRunnable.run();
            }
            catch (Throwable tr)
            {
                LOG.e("running task occurs exception:", tr);
            }
            finally {
                // TODO: 2016/6/7 11:38 监控程序运行效率的工具类实现后要记录程序运行的结束
            }
        }
    }
}
