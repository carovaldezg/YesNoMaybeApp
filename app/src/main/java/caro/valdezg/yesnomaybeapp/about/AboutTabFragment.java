package caro.valdezg.yesnomaybeapp.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import caro.valdezg.yesnomaybeapp.R;

public class AboutTabFragment extends Fragment {

    @BindView(R.id.fragment_question_title_bar_toolbar)
    Toolbar mToolbar;

    public AboutTabFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this,rootView);
        mToolbar.setTitle(R.string.question_bar_title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Shamrock));
        return rootView;
    }

}
