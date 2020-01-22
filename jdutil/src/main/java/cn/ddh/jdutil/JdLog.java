package cn.ddh.jdutil;

import android.util.Log;

public class JdLog {


    private static String TAG = "----v2x----";

    private static boolean logOpen = false;


    /**
     * 设置log的开关
     *
     * @param isOpen 是否开启，默认是关闭
     */
    public static void setLogOpen(boolean isOpen) {
        logOpen = isOpen;
    }


    /**
     * 重新自定义log的tag
     *
     * @param tag 想要设置的tag
     */
    public static void setLogTag(String tag) {
        if (tag == null || tag.equals("")) {
            return;
        }
        TAG = tag;
    }


    public static void d(Class<?> className, String msg) {
        if (logOpen) {
            Log.d(TAG, (String.format("[%s][%s]", className.getName(), msg)));
        }
    }
}
