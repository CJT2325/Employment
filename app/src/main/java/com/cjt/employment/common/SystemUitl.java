package com.cjt.employment.common;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

/**
 * 作者: 陈嘉桐 on 2016/10/25
 * 邮箱: 445263848@qq.com.
 */
public class SystemUitl {
    public static boolean inMainProcess(Context context) {
        String packageName = context.getPackageName();
        String processName = SystemUitl.getProcessName(context);
        return packageName.equals(processName);
    }

    /**
     * 获取当前进程名
     *
     * @param context
     * @return 进程名
     */
    public static final String getProcessName(Context context) {
        String processName = null;

        // ActivityManager
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));

        while (true) {
            for (ActivityManager.RunningAppProcessInfo info : am.getRunningAppProcesses()) {
                if (info.pid == android.os.Process.myPid()) {
                    processName = info.processName;
                    break;
                }
            }

            // go home
            if (!TextUtils.isEmpty(processName)) {
                return processName;
            }

            // take a rest and again
            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
