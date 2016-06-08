package com.maixianda.copy.liangce.mxdlibrary.Util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2016/6/7.
 * 说明:           日志工厂，选择日志实现方式
 *                 1.常规Console日志输出
 *                 2.文件日志输出
 * 创建人:         maixianda
 * 创建时间:       2016/6/7 14:31
 */
public class LoggerFactory {
    public static Logger getLogger(String tag)
    {
        try {
            Constructor<? extends Logger> constructor = LogConfig.LOGGER_CLASS.getDeclaredConstructor(new Class[]{String.class});
            return constructor.newInstance(tag);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new Logger(tag);
    }

    public static Logger getLogger(Class clazz) {
        return getLogger(clazz.getSimpleName());
    }
}
