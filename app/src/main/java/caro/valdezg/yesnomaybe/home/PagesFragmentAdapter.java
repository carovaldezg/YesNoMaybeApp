package caro.valdezg.yesnomaybe.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import caro.valdezg.yesnomaybe.R;
import caro.valdezg.yesnomaybe.about.AboutTabFragment;
import caro.valdezg.yesnomaybe.profile.ProfileTabFragment;
import caro.valdezg.yesnomaybe.questionTab.QuestionTabFragment;

public class PagesFragmentAdapter  extends FragmentPagerAdapter {

    private Fragment[] mTabFragments;
    private String[] mTabTitles;

    public PagesFragmentAdapter(FragmentManager fm, Context context ) {
        super(fm);
        mTabFragments = getFragments();
        mTabTitles = context.getResources().getStringArray(tabTitlesArrayRes());
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < mTabFragments.length)
            return mTabFragments[position];

        return null;
    }

    @Override
    public int getCount() {
        return mTabFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }

    protected int tabTitlesArrayRes() {
        return R.array.home_tabs_title;
    }

    @NonNull
    protected Fragment[] getFragments() {
        return new Fragment[]{new QuestionTabFragment(), new ProfileTabFragment(), new AboutTabFragment()};
    }

}
