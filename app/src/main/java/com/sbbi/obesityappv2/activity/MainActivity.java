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


//public class MainActivity extends ActionBarActivity implements EventLayoutAfterRequestInterf {

    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    private EditText prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        /*mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.black);
            }
        });*/

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings)
            return true;

        if(id == R.id.action_feedback){
            startActivity(new Intent(this, FeedbackActivity.class));
        }

        if(id == R.id.action_about){
            startActivity(new Intent(this, AboutActivity.class));
        }


        if(id == R.id.addVenue) {
            startActivity(new Intent(this, InsertVenueActivity.class));
        }

        if(id == R.id.addEvent)
            startActivity(new Intent(this, InsertEventActivity.class));*/



        return super.onOptionsItemSelected(item);
    }

    private void alert() {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View promptView = inflater.inflate(R.layout.prompt, null);
        prompt = (EditText) promptView.findViewById(R.id.prompt_input);
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setView(promptView);
        b.setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("bruno",prompt.getText().toString());
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("bruno","apertou cancelar");
            }
        });

        AlertDialog alert = b.create();
        alert.show();*/
    }

    /*@Override
    public void setLayoutAfterRequest(Event[] events) {
        //eventAdapter = new VenueRecyclerAdapter(getApplicationContext(), events, this);
        //recyclerView.setAdapter(event);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }*/

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