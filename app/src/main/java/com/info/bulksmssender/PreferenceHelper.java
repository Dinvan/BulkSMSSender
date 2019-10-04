package com.info.bulksmssender;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private final static String PREF_FILE = "SMS_PREFERENCE";
    public final static String LAST_INDEX="last_index";



/*    public  static void setSharedPreferenceLong(Context context, String key, long value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getSharedPreferenceLong(Context context, String key, long defValue){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getLong(key, defValue);
    }*/

    public  static void setSharedPreferenceInt(Context context, String key, int value){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getSharedPreferenceInt(Context context, String key, int defValue){
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(key, defValue);
    }
}
