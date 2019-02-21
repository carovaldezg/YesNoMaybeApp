package caro.valdezg.yesnomaybeapp.common.network;


import com.google.gson.annotations.SerializedName;

public class YesNoMaybeResponse {

    @SerializedName("answer")
    private String answer;
    @SerializedName("forced")
    private Boolean forced;
    @SerializedName("image")
    private String image;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getForced() {
        return forced;
    }

    public void setForced(Boolean forced) {
        this.forced = forced;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
