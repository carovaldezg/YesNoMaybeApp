package caro.valdezg.yesnomaybeapp.googleLogin;

import caro.valdezg.yesnomaybeapp.common.mvp.views.IBaseView;

public interface ILoginView extends IBaseView {

    class OnFailedSignIn implements State {

        OnFailedSignIn() {}

    }

    class NavigateToHomeScreen implements State {

        NavigateToHomeScreen() { }

    }

}