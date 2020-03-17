package com.techpakka.mysongs;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    Context context;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public PrefManager(Context activity) {
        this.context = activity;
        sharedPreferences = activity.getSharedPreferences("my_sharedpreference_file_name", Context.MODE_PRIVATE);
        //we need editor to edit created shared preference file
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void putString(String key, String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key,String defaultstring) {
        return sharedPreferences.getString(key, defaultstring);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value).apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }
    public void putLong(String key, long value) {
        editor.putLong(key, value).apply();
    }

    public Long getLong(String key) {
        return sharedPreferences.getLong(key, 1234);
    }



    public void deleteAll() {
        editor.clear().apply();
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void delete(String key) {
        editor.remove(key).apply();
    }


}
