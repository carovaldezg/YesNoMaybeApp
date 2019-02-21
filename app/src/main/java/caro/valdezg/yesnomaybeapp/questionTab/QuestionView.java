package caro.valdezg.yesnomaybeapp.questionTab;

import caro.valdezg.yesnomaybeapp.common.mvp.views.IBaseView;
import caro.valdezg.yesnomaybeapp.common.network.YesNoMaybeResponse;
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
