package caro.valdezg.yesnomaybeapp.questionTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caro.valdezg.yesnomaybeapp.R;

public class QuestionTabFragment extends Fragment implements QuestionView {

    @BindView(R.id.fragment_question_ask_button)
    Button mAskButton;
    @BindView(R.id.fragment_question_title_bar_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fragment_question_question_linear_layout)
    LinearLayout mQuestionLayout;
    @BindView(R.id.fragment_question_answer_linear_layout)
    LinearLayout mAnswerLayout;
    @BindView(R.id.fragment_question_ask_again_text_view)
    TextView mAskAgainButton;
    @BindView(R.id.fragment_question_answer_img_image_view)
    ImageView mAnswerGif;
    @BindView(R.id.fragment_question_answer_text_view)
    TextView mAnswer;

    private QuestionPresenter mQuestionPresenter;

    public QuestionTabFragment() {
        mQuestionPresenter = new QuestionPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.bind(this,rootView);
        mToolbar.setTitle(R.string.question_bar_title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Shamrock));
        return rootView;
    }

    @OnClick(R.id.fragment_question_ask_button)
    public void onClickAskButton() {
        mAskButton.setClickable(false);
        mQuestionPresenter.getAnswerToTheQuestion();
    }

    @OnClick(R.id.fragment_question_ask_again_text_view)
    public void onClickAskAgain() {
        mAskAgainButton.setClickable(false);
        mAskButton.setClickable(true);
        mAnswerLayout.setVisibility(View.GONE);
        mQuestionLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void render(@NonNull State state) {
        if (state instanceof ShowAnswer) {
            renderShowAnswer((ShowAnswer) state);
        } else if (state instanceof ShowErrorState) {
            renderShowErrorState();
        }
    }

    private void renderShowAnswer(ShowAnswer state) {
        mAskAgainButton.setClickable(true);
        String answer = state.yesNoMaybeResponse.getAnswer().toUpperCase() + "!!!";
        mAnswer.setText(answer);
        Glide.with(getContext())
                .load(state.yesNoMaybeResponse.getImage())
                .asGif()
                .into(mAnswerGif);
        mQuestionLayout.setVisibility(View.GONE);
        mAnswerLayout.setVisibility(View.VISIBLE);
    }

    private void renderShowErrorState() {

    }

}
