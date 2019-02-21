package caro.valdezg.yesnomaybeapp.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
        setContentView(R.layout.activity_home_tabs);
        ButterKnife.bind(this);
        mPagerAdapter = new PagesFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);
    }

}