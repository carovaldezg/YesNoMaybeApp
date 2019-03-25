package caro.valdezg.yesnomaybe.common.mvp.views;


import androidx.annotation.NonNull;

/**
 * Base MVP view.
 */
public interface IBaseView {

    interface State {}

    void render(@NonNull State state);

}