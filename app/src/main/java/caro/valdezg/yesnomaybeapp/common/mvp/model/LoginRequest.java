package caro.valdezg.yesnomaybeapp.common.mvp.model;


import androidx.annotation.NonNull;

public class LoginRequest {

    private String idToken;
    private String email;
    private String username;
    private String fullName;
    private String uid;
    private String aud;

    public LoginRequest(@NonNull String accessToken, @NonNull String userFamilyName,
                        @NonNull String userEmail, @NonNull String userName,
                        @NonNull String userGivenName, @NonNull String googleId) {
        this.idToken = accessToken;
        this.email = userEmail;
        this.username = userName;
        this.fullName = userGivenName + " " + userFamilyName;
        this.uid = googleId;
    }

}
