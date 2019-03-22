package caro.valdezg.yesnomaybeapp.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caro.valdezg.yesnomaybeapp.R;
import caro.valdezg.yesnomaybeapp.common.YesNoMaybeApplication;
import caro.valdezg.yesnomaybeapp.common.mvp.model.LoginRequest;
import caro.valdezg.yesnomaybeapp.common.mvp.views.ILoadingView;
import caro.valdezg.yesnomaybeapp.common.ui.CircleTransform;
import caro.valdezg.yesnomaybeapp.googleLogin.GoogleLoginActivity;

public class ProfileTabFragment extends Fragment implements ILoadingView {

    @BindView(R.id.fragment_profile_title_bar_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fragment_profile_user_name)
    TextView mUserName;
    @BindView(R.id.fragment_profile_name)
    TextView mName;
    @BindView(R.id.fragment_profile_user_email)
    TextView mEmail;
    @BindView(R.id.fragment_profile_log_out_text_view)
    TextView mLogout;
    GoogleApiClient mGoogleApiClient;
    @BindView(R.id.fragment_profile_profile_image)
    ImageView mUserImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,rootView);
        mToolbar.setTitle(R.string.profile_bar_title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Shamrock));
        setUI();
        return rootView;
    }

    private void setUI() {
        LoginRequest loginRequest = LoginRequest.getsInstance();
        if (loginRequest != null) {
            Glide.with(getActivity()).load(loginRequest.getUserPhoto()).transform
                    (new CircleTransform(this.getActivity())).into(mUserImage);
            mUserName.setText(loginRequest.getUsername());
            mName.setText(loginRequest.getFullName());
            mEmail.setText(loginRequest.getEmail());
        } else
            mName.setText(getResources().getString(R.string.no_user_info_found));
    }

    @Override
    public void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(YesNoMaybeApplication.getAppContext())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    public void render(@NonNull State state) {

    }

    @OnClick
    public void onClickLogOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Intent intent = new Intent(getActivity(), GoogleLoginActivity.class);
                        startActivity(intent);
                    }
                });
    }

}
