package caro.valdezg.yesnomaybeapp.splashscreen;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SplashScreenPresenter {

    private final SplashScreenView mViewInstance;

    public SplashScreenPresenter(SplashScreenView mainActivity) {
        mViewInstance = mainActivity;
    }


    public void validateSignInStatus(GoogleSignInAccount alreadyloggedAccount) {
        if (alreadyloggedAccount == null) {
            mViewInstance.render(new SplashScreenView.ShowSignInScreen());
        } else
            mViewInstance.render(new SplashScreenView.ShowNextScreen());
    }

}
