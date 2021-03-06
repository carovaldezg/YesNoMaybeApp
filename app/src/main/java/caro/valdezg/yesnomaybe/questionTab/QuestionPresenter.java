package caro.valdezg.yesnomaybe.questionTab;

import caro.valdezg.yesnomaybe.common.RetrofitInstance;
import caro.valdezg.yesnomaybe.common.mvp.views.ILoadingView;
import caro.valdezg.yesnomaybe.common.network.QuestionService;
import caro.valdezg.yesnomaybe.common.network.YesNoMaybeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter {

    private final QuestionView mViewInstance;

    public QuestionPresenter(QuestionView mainActivity) {
        mViewInstance = mainActivity;
    }

    public void getAnswerToTheQuestion() {
        mViewInstance.render(new ILoadingView.ShowLoadingState());
        QuestionService service = RetrofitInstance.getRetrofitInstance().create(QuestionService.class);
        Call<YesNoMaybeResponse> call = service.getAnswer();
        call.enqueue(new Callback<YesNoMaybeResponse>() {
            @Override
            public void onResponse(Call<YesNoMaybeResponse> call, Response<YesNoMaybeResponse> response) {
                mViewInstance.render(new QuestionView.ShowAnswer(response));
            }

            @Override
            public void onFailure(Call<YesNoMaybeResponse> call, Throwable t) {
                mViewInstance.render(new QuestionView.ShowErrorState());
            }

        });
    }

}
