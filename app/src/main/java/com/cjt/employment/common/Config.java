package com.cjt.employment.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者: 陈嘉桐 on 2016/7/4
 * 邮箱: 445263848@qq.com.
 */
public class Config {
    public static String APP = "com.cjt.employment";
    public static String KEY_USERID = "keyuserid";
    public static String KEY_PHONE = "keyphone";
    public static String KEY_USERNAME = "keypassword";
    public static String KEY_TOKEN = "keytoken";

    public static void saveValueByKey(Context context, String key, String value) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(APP, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getValueByKey(Context context, String key) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(APP, Activity.MODE_PRIVATE);
        return mySharedPreferences.getString(key, "");
    }

    public static void clearAll(Context context) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(APP, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.remove(KEY_USERID);
        editor.remove(KEY_TOKEN);
        editor.commit();
    }
}
