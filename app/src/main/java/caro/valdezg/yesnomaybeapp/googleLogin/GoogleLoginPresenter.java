package caro.valdezg.yesnomaybeapp.googleLogin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import caro.valdezg.yesnomaybeapp.common.mvp.model.LoginRequest;
import caro.valdezg.yesnomaybeapp.common.mvp.views.ILoadingView;


public class GoogleLoginPresenter {

    private final ILoginView mViewInstance;
    private GoogleSignInAccount mGoogleSignInAccount;
    private LoginRequest loginRequest;

    public GoogleLoginPresenter(ILoginView mainActivity) {
        mViewInstance = mainActivity;
    }


    public void onGoogleSignIn(final GoogleSignInAccount googleSignInAccount) {
        if (mViewInstance == null) return;

        mViewInstance.render(new ILoadingView.ShowLoadingState());
        if (googleSignInAccount != null) {
            loginRequest = new LoginRequest(googleSignInAccount.getIdToken(),
                    googleSignInAccount.getFamilyName(), googleSignInAccount.getEmail(),
                    googleSignInAccount.getDisplayName(), googleSignInAccount.getGivenName(),
                    googleSignInAccount.getId());
            mGoogleSignInAccount = googleSignInAccount;
            mViewInstance.render(new ILoginView.NavigateToHomeScreen());
        } else {
                mViewInstance.render(new ILoginView.OnFailedSignIn());
        }
    }

}
