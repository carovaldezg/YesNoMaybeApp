package caro.valdezg.yesnomaybeapp.questionTab;

import caro.valdezg.yesnomaybeapp.common.RetrofitInstance;
import caro.valdezg.yesnomaybeapp.common.network.QuestionService;
import caro.valdezg.yesnomaybeapp.common.network.YesNoMaybeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class QuestionPresenter {

    private final QuestionView mViewInstance;

    public QuestionPresenter(QuestionView mainActivity) {
        mViewInstance = mainActivity;
    }

    public void getAnswerToTheQuestion() {
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
