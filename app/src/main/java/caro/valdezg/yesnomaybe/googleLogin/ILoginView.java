package caro.valdezg.yesnomaybe.googleLogin;

import caro.valdezg.yesnomaybe.common.mvp.views.IBaseView;

public interface ILoginView extends IBaseView {

    class OnFailedSignIn implements State {

        OnFailedSignIn() {}

    }

    class NavigateToHomeScreen implements State {

        NavigateToHomeScreen() { }

    }

}