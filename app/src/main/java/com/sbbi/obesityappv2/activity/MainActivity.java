package com.sbbi.obesityappv2.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.fragment.InsightsFragment;
import com.sbbi.obesityappv2.fragment.MyMealsFragment;
import com.sbbi.obesityappv2.fragment.PreferencesFragment;
import com.sbbi.obesityappv2.tabs.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mTabs.setDistributeEvenly(true);
        mTabs.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    class MyPageAdapter extends FragmentPagerAdapter {

        private final int TOTAL_TABS = 3, MY_MEALS = 0, INSIGHTS = 1, PREFERENCES = 2;
        private String[] tabs;

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.tabs)[position];
        }

        @Override
        public Fragment getItem(int position) {

            if(position == MY_MEALS)
                return new MyMealsFragment();
            else if(position == PREFERENCES)
                return new PreferencesFragment();
            else if(position == INSIGHTS)
                return new InsightsFragment();

            return null;
        }

        @Override
        public int getCount() {
            return TOTAL_TABS;
        }
    }
}