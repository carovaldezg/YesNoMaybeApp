package caro.valdezg.yesnomaybeapp.common;

import android.content.SharedPreferences;

public class BaseConfiguration {

    public static class Router {

        public static int SPLASH_DELAY = 1500;

    }

    public static class Login {

        public static final int GOOGLE_SIGN_IN_TRIES = 10;

    }

    public static final class SharedPreferences {
        public static final String IS_LOGIN = "is_signed_in";
        public static final String SHARED_PREFERENCES_NAME = "yesnomaybe_sp";
        public static final String USER_FIRST_NAME = "user_first_name";
        public static final String USER_FAMILY_NAME = "user_family_name";
        public static final String USER_EMAIL = "user_email";

    }

    public static final String PUBLIC_ID = "29458728256-ir69v63n67kdlrrjpjcm8tfmciclpvei.apps.googleusercontent.com";

}