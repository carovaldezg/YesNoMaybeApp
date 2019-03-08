package caro.valdezg.yesnomaybeapp.googleLogin;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import caro.valdezg.yesnomaybeapp.common.mvp.model.LoginRequest;
import caro.valdezg.yesnomaybeapp.common.mvp.views.ILoadingView;


public class GoogleLoginPresenter {

    private final ILoginView mViewInstance;
    private GoogleSignInAccount mGoogleSignInAccount;
    private LoginRequest loginRequest;

    public GoogleLoginPresenter(ILoginView mainActivity) {
        mViewInstance = mainActivity;
        loginRequest = null;
    }


    public void onGoogleSignIn(final GoogleSignInAccount googleSignInAccount) {
        if (mViewInstance == null) return;
        mGoogleSignInAccount = googleSignInAccount;
        mViewInstance.render(new ILoadingView.ShowLoadingState());
        if (mGoogleSignInAccount != null) {
            loginRequest = LoginRequest.getsInstance();
            loginRequest.saveUserData( mGoogleSignInAccount.getEmail(),
                    mGoogleSignInAccount.getGivenName() + " "+ mGoogleSignInAccount.getFamilyName(),
                     mGoogleSignInAccount.getDisplayName());
            mViewInstance.render(new ILoginView.NavigateToHomeScreen());
        } else {
                mViewInstance.render(new ILoginView.OnFailedSignIn());
        }
    }

}
