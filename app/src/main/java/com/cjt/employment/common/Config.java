package com.cjt.employment.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cjt.employment.bean.UserBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netease.nim.uikit.contact.core.model.IContact;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    public static String KEY_LIST = "listdata";

    private static final String KEY_USER_ACCOUNT = "account";
    private static final String KEY_USER_TOKEN = "token";

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
        editor.remove(KEY_LIST);
        editor.commit();
    }


    public static void saveUserAccount(String account) {
        saveString(KEY_USER_ACCOUNT, account);
    }

    public static String getUserAccount() {
        return getString(KEY_USER_ACCOUNT);
    }

    public static void saveUserToken(String token) {
        saveString(KEY_USER_TOKEN, token);
    }

    public static String getUserToken() {
        return getString(KEY_USER_TOKEN);
    }

    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }

    static SharedPreferences getSharedPreferences() {
        return DemoCache.getContext().getSharedPreferences(APP, Context.MODE_PRIVATE);
    }


    public static void saveList(Context context, List<UserBean> datas) {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(datas);
        editor.putString(KEY_LIST, json);
        editor.commit();
    }

    public static List getList(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP, Context.MODE_PRIVATE);
        String json = preferences.getString(KEY_LIST, null);
        if (json != null) {
            Log.i("CJT", "-=-=-=-=-=-=-=-=-=-=-=-" + json);
            Gson gson = new Gson();
            Type type = new TypeToken<List<UserBean>>() {
            }.getType();
            List<UserBean> datas = new ArrayList<UserBean>();
            datas = gson.fromJson(json, type);
            return datas;
        } else {
            return null;
        }
    }

    public static void addUserBeanToList(Context context, UserBean userBean) {
        SharedPreferences preferences = context.getSharedPreferences(APP, Context.MODE_PRIVATE);
        String json = preferences.getString(KEY_LIST, null);
        boolean canAdd = true;
        if (json != null) {
            Log.i("CJT", "-=-=-=-=-=-=-=-=-=-=-=-" + json);
            Gson gson = new Gson();
            Type type = new TypeToken<List<UserBean>>() {
            }.getType();
            List<UserBean> datas = new ArrayList<UserBean>();
            datas = gson.fromJson(json, type);
                for (int i = 0; i < datas.size(); i++) {
                    if (Integer.parseInt(datas.get(i).getId()) == Integer.parseInt(userBean.getId())) {
                        canAdd = false;
                    }
                }
            if (canAdd){
                datas.add(userBean);
                saveList(context,datas);
            }
        }
    }
}
