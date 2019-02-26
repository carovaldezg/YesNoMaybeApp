package caro.valdezg.yesnomaybeapp.about;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caro.valdezg.yesnomaybeapp.R;

public class AboutTabFragment extends Fragment {

    @BindView(R.id.fragment_question_title_bar_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fragment_about_medium_image_view)
    ImageView mMediumIcon;
    @BindView(R.id.fragment_about_github_linear_layout)
    LinearLayout mGithubLogo;
    @BindView(R.id.fragment_about_keep_in_touch_linear_layout)
    LinearLayout mLinkedinLogo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this,rootView);
        mToolbar.setTitle(R.string.question_bar_title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Shamrock));
        return rootView;
    }

    private void openBrowser(int resource) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(resource)));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.error_no_browser_found), Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fragment_about_github_linear_layout)
    public void openGithub() {
        openBrowser(R.string.github_url);
    }

    @OnClick(R.id.fragment_about_keep_in_touch_linear_layout)
    public void openLinkedin() {
        openBrowser(R.string.linkedin_url);
    }

    @OnClick(R.id.fragment_about_medium_image_view)
    public void openMedium() {
        openBrowser(R.string.medium_url);
    }

}
