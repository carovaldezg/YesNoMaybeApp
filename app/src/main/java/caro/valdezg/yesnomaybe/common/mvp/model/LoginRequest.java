package caro.valdezg.yesnomaybe.common.mvp.model;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import caro.valdezg.yesnomaybe.common.BaseConfiguration;
import caro.valdezg.yesnomaybe.common.YesNoMaybeApplication;

public class LoginRequest {

    private static volatile LoginRequest sInstance = new LoginRequest();
    SharedPreferences sharepreferences;

    public LoginRequest() {}

    public String getEmail() {
        sharepreferences = PreferenceManager
                .getDefaultSharedPreferences(YesNoMaybeApplication.getAppContext());
        return sharepreferences.getString(BaseConfiguration.SharedPreferences.USER_EMAIL, null);
    }

    public String getUsername() {
        sharepreferences = PreferenceManager
                .getDefaultSharedPreferences(YesNoMaybeApplication.getAppContext());
        return sharepreferences.getString(BaseConfiguration.SharedPreferences.USER_DISPLAY_NAME, null);
    }

    public String getFullName() {

        sharepreferences = PreferenceManager
                .getDefaultSharedPreferences(YesNoMaybeApplication.getAppContext());
        return sharepreferences.getString(BaseConfiguration.SharedPreferences.USER_NAME, null);
    }

    public String getUserPhoto() {
        sharepreferences = PreferenceManager
                .getDefaultSharedPreferences(YesNoMaybeApplication.getAppContext());
        return sharepreferences.getString(BaseConfiguration.SharedPreferences.USER_PHOTO_URI, null);
    }

    public static LoginRequest getsInstance() {

        if (sInstance == null) {
            return new LoginRequest();
        } else
            return sInstance;
    }

    public void saveUserData(String email, String name, String userName, String userPhoto) {
        sharepreferences = PreferenceManager
                .getDefaultSharedPreferences(YesNoMaybeApplication.getAppContext());
        SharedPreferences.Editor editor = sharepreferences.edit();
        editor.putString(BaseConfiguration.SharedPreferences.USER_EMAIL, email);
        editor.putString(BaseConfiguration.SharedPreferences.USER_DISPLAY_NAME, userName);
        editor.putString(BaseConfiguration.SharedPreferences.USER_NAME, name);
        editor.putString(BaseConfiguration.SharedPreferences.USER_PHOTO_URI, userPhoto);
        editor.commit();
    }

}
