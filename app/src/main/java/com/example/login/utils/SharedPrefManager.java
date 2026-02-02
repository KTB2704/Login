package com.example.login.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "app_prefs";
    private static final String KEY_ACCESS = "ACCESS_TOKEN";
    private static final String KEY_REFRESH = "REFRESH_TOKEN";
    private static final String KEY_USERNAME = "USERNAME";
    private static final String KEY_EMAIL = "EMAIL";

    private SharedPreferences prefs;

    public SharedPrefManager(Context context){
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveAuth(String access,
                         String refresh,
                         String username,
                         String email){
        prefs.edit()
                .putString(KEY_ACCESS, access)
                .putString(KEY_REFRESH, refresh)
                .putString(KEY_USERNAME, username)
                .putString(KEY_EMAIL, email)
                .apply();

    }

    public String getAccessToken() {
        return prefs.getString(KEY_ACCESS, null);
    }

    public String getRefreshToken() {
        return prefs.getString(KEY_REFRESH, null);
    }

    public String getUsername() {
        return prefs.getString(KEY_USERNAME, null);
    }

    public String getEmail() {
        return prefs.getString(KEY_EMAIL, null);
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
