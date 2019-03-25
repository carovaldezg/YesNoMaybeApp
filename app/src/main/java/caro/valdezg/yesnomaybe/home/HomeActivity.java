package caro.valdezg.yesnomaybe.home;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import caro.valdezg.yesnomaybe.R;
import caro.valdezg.yesnomaybe.common.ui.IconTextTabItem;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.activity_home_view_pager)
    ViewPager mViewPager;
    PagesFragmentAdapter mPagerAdapter;
    @BindView(R.id.activity_home_tab_layout)
    TabLayout mTabLayout;
    @BindArray(R.array.home_tabs_title)
    String[] mTabsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_tabs);
        ButterKnife.bind(this);
        mTabsTitle = getResources().getStringArray(R.array.home_tabs_title);
        mPagerAdapter = new PagesFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);

        IconTextTabItem tabItemGoals = new IconTextTabItem
                (this, mTabsTitle[0], R.drawable.ic_question);
        IconTextTabItem tabItemTasks = new IconTextTabItem
                (this, mTabsTitle[1], R.drawable.ic_userprofile);
        IconTextTabItem tabItemSale = new IconTextTabItem
                (this, mTabsTitle[2], R.drawable.ic_about);

        mTabLayout.getTabAt(0).setCustomView(tabItemGoals);
        mTabLayout.getTabAt(1).setCustomView(tabItemTasks);
        mTabLayout.getTabAt(2).setCustomView(tabItemSale);
        mTabLayout.setTabTextColors(R.color.colorPrimaryDark, R.color.colorPrimary);
    }

}