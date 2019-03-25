package caro.valdezg.yesnomaybe.splashscreen;

import caro.valdezg.yesnomaybe.common.mvp.views.IBaseView;
import caro.valdezg.yesnomaybe.common.mvp.views.IErrorView;
import caro.valdezg.yesnomaybe.common.mvp.views.ILoadingView;

public interface SplashScreenView extends IBaseView, IErrorView, ILoadingView {


    class ShowSplashState {

        ShowSplashState() {}

    }

    class ShowNextScreen implements State {

        ShowNextScreen() {}

    }

    public class ShowSignInScreen implements State {

        ShowSignInScreen() {}

    }

}
