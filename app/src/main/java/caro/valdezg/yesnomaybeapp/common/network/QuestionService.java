package caro.valdezg.yesnomaybeapp.common.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {

    @GET("/api")
    Call<YesNoMaybeResponse> getAnswer();

}
