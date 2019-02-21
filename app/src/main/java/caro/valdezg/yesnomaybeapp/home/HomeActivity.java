package caro.valdezg.yesnomaybeapp.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import caro.valdezg.yesnomaybeapp.R;

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
        mPagerAdapter = new PagesFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);
    }

}