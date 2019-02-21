package caro.valdezg.yesnomaybeapp.googleLogin;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import caro.valdezg.yesnomaybeapp.R;
import caro.valdezg.yesnomaybeapp.common.mvp.views.ILoadingView;
import caro.valdezg.yesnomaybeapp.common.ui.LoadingUtils;
import caro.valdezg.yesnomaybeapp.home.HomeActivity;

public class GoogleLoginActivity extends AppCompatActivity implements ILoginView, ILoadingView,
        GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9001;

    SignInButton mGoogleSignInButton;

    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInClient googleSignInClient;
    private Dialog mLoadingDialog;
    private GoogleSignInOptions gso;
    private GoogleLoginPresenter googleLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_google_login);
        init();

    }

    public void init() {
        googleLoginPresenter = new GoogleLoginPresenter(this);
        mLoadingDialog = LoadingUtils.buildLoadingDialog(GoogleLoginActivity.this);
        mGoogleSignInButton = findViewById(R.id.sign_in_button);
        gso = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        mGoogleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInButton.setClickable(false);
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        mGoogleApiClient = new GoogleApiClient.Builder(GoogleLoginActivity.this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            googleLoginPresenter.onGoogleSignIn(acct);
        } else {
            Toast.makeText(this,getResources().getString(
                    R.string.no_internet_error), Toast.LENGTH_LONG).show();
        }
    }

    public void onDestroyView() {
        onDestroyView();
        mGoogleApiClient.stopAutoManage(this);
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,getResources().getString(
                R.string.error_connecting_google_services), Toast.LENGTH_LONG).show();
    }

    @Override
    public void render(@NonNull State state) {
        if (state instanceof OnFailedSignIn) {
            renderOnFailedSignIn();
        } else if (state instanceof NavigateToHomeScreen) {
            renderNavigateToHomeScreen();
        } else if (state instanceof ILoadingView.ShowLoadingState) {
            renderShowLoadingState((ILoadingView.ShowLoadingState) state);
        }
    }

    private void renderOnFailedSignIn() {
        mLoadingDialog.dismiss();
        mGoogleSignInButton.setClickable(true);
        Toast.makeText(this,getResources().getString(
                R.string.error_unexpecter_api_server_error), Toast.LENGTH_LONG).show();
    }

    private void renderNavigateToHomeScreen() {
        mLoadingDialog.dismiss();
        startActivity(new Intent(GoogleLoginActivity.this, HomeActivity.class));
        finish();
    }

    private void renderShowLoadingState(ShowLoadingState state) {
        mLoadingDialog.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}

}
