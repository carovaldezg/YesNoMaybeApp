package caro.valdezg.yesnomaybeapp.questionTab;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caro.valdezg.yesnomaybeapp.R;
import caro.valdezg.yesnomaybeapp.common.mvp.views.ILoadingView;
import caro.valdezg.yesnomaybeapp.common.ui.LoadingUtils;

public class QuestionTabFragment extends Fragment implements QuestionView, ILoadingView {

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
    @BindView(R.id.fragment_question_share_image_view)
    ImageView mShareButton;

    private QuestionPresenter mQuestionPresenter;
    private Dialog mLoadingDialog;


    public QuestionTabFragment() {
        mQuestionPresenter = new QuestionPresenter(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mLoadingDialog = LoadingUtils.buildLoadingDialog(getActivity());
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
        mAnswer.setVisibility(View.INVISIBLE);
    }

    @Override
    public void render(@NonNull State state) {
        if (state instanceof ShowAnswer) {
            renderShowAnswer((ShowAnswer) state);
        } else if (state instanceof ShowErrorState) {
            renderShowErrorState();
        } else if (state instanceof ShowLoadingState) {
            renderShowLoadingState((ShowLoadingState) state);
        }
    }

    private void renderShowLoadingState(ILoadingView.ShowLoadingState state) {
        mLoadingDialog.show();
    }

    private void renderShowAnswer(ShowAnswer state) {
        mAskAgainButton.setClickable(true);

        Glide.with(getContext())
                .load(state.yesNoMaybeResponse.getImage()).centerCrop()
                .listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                mLoadingDialog.dismiss();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                mLoadingDialog.dismiss();
                String answer = state.yesNoMaybeResponse.getAnswer().toUpperCase() + "!!!";
                mAnswer.setText(answer);
                mAnswer.setVisibility(View.VISIBLE);
                return false;
            }
        })
                .into(mAnswerGif);
        mQuestionLayout.setVisibility(View.GONE);
        mAnswerLayout.setVisibility(View.VISIBLE);
    }

    private void renderShowErrorState() {
        mLoadingDialog.dismiss();
        Toast.makeText(this.getContext(), getString(R.string.error_unexpecter_api_server_error), Toast.LENGTH_LONG).show();
    }

    @OnClick
    protected void onClickShareButton() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getResources().getString(R.string.share_body_text) + mAnswer.getText();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.share_subject));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_via)));
    }

}
