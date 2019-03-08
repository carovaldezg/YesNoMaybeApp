package caro.valdezg.yesnomaybeapp.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import caro.valdezg.yesnomaybeapp.R;
import caro.valdezg.yesnomaybeapp.common.BaseConfiguration;
import caro.valdezg.yesnomaybeapp.googleLogin.GoogleLoginActivity;
import caro.valdezg.yesnomaybeapp.home.HomeActivity;


public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    SplashScreenPresenter splashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        splashScreenPresenter = new SplashScreenPresenter(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                GoogleSignInAccount alreadyloggedAccount =
                        GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                splashScreenPresenter.validateSignInStatus(alreadyloggedAccount);            }
        }, BaseConfiguration.Router.SPLASH_DELAY);
    }

    @Override
    public void render(@NonNull State state) {
        if (state instanceof ShowNextScreen) {
            renderShowNextScreen();
        } else if (state instanceof ShowSignInScreen) {
            renderShowSignInScreen();
        }
    }

    private void renderShowSignInScreen() {
        Intent nextscreenIntent = new Intent(SplashScreenActivity.this, GoogleLoginActivity.class);
        openScreen(nextscreenIntent);
    }

    private void renderShowNextScreen() {
        Intent nextscreenIntent = new Intent(SplashScreenActivity.this, HomeActivity.class);
        openScreen(nextscreenIntent);
    }

    private void openScreen(Intent mainIntent) {
        SplashScreenActivity.this.startActivity(mainIntent);
        SplashScreenActivity.this.finish();
    }

}
