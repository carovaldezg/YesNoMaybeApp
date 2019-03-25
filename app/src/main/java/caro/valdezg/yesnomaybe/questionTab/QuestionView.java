package caro.valdezg.yesnomaybe.questionTab;

import caro.valdezg.yesnomaybe.common.mvp.views.IBaseView;
import caro.valdezg.yesnomaybe.common.network.YesNoMaybeResponse;
import retrofit2.Response;

interface QuestionView extends IBaseView {


    class ShowAnswer implements State {

        YesNoMaybeResponse yesNoMaybeResponse;

        public ShowAnswer(Response<YesNoMaybeResponse> response) {
            this.yesNoMaybeResponse = response.body();
        }
    }

    class ShowErrorState implements State {

        public ShowErrorState() {}

    }

}
