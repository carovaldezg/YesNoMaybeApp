package caro.valdezg.yesnomaybeapp.questionTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caro.valdezg.yesnomaybeapp.R;

public class QuestionTabFragment extends Fragment implements QuestionView {

    @BindView(R.id.fragment_question_ask_button)
    Button askButton;
    @BindView(R.id.fragment_question_title_bar_toolbar)
    Toolbar mToolbar;

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
        mQuestionPresenter.getAnswerToTheQuestion();
    }


    @Override
    public void render(@NonNull State state) {

    }
}
