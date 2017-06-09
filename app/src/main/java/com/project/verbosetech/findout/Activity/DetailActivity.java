package com.project.verbosetech.findout.Activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.project.verbosetech.findout.Fragments.InfoFragment;
import com.project.verbosetech.findout.Fragments.MapFragment;
import com.project.verbosetech.findout.Fragments.OffersFragment;
import com.project.verbosetech.findout.Fragments.ReviewFragement;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by this pc on 08-06-17.
 */

public class DetailActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;
    RatingBar ratingBar;
    TextView tabOne;
    TextView tabTwo;
    TextView tabThree;
    TextView tabfour;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_layout);

        ratingBar=(RatingBar)findViewById(R.id.rating_bar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_ATOP);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        createViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_host);
        tabLayout.setupWithViewPager(viewPager);
        setUpText();
        tabLayout.addOnTabSelectedListener(this);
    }

    public void setUpText(){

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Info");
        tabOne.setTextColor(Color.BLACK);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Offers");
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Reviews");
        tabLayout.getTabAt(2).setCustomView(tabThree);

        tabfour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfour.setText("Map");
        tabLayout.getTabAt(3).setCustomView(tabfour);
    }

    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new InfoFragment(), "Info");
        adapter.addFrag(new OffersFragment(), "Offers");
        adapter.addFrag(new ReviewFragement(), "Reviews");
        adapter.addFrag(new MapFragment(), "Map");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        int position=tabLayout.getSelectedTabPosition();
        if(position==0){

            tabOne.setTextColor(Color.BLACK);
            tabTwo.setTextColor(Color.GRAY);
            tabThree.setTextColor(Color.GRAY);
            tabfour.setTextColor(Color.GRAY);

        }
        else if(position==1){
            tabOne.setTextColor(Color.GRAY);
            tabTwo.setTextColor(Color.BLACK);
            tabThree.setTextColor(Color.GRAY);
            tabfour.setTextColor(Color.GRAY);
        }
        else if(position==2){
            tabOne.setTextColor(Color.GRAY);
            tabTwo.setTextColor(Color.GRAY);
            tabThree.setTextColor(Color.BLACK);
            tabfour.setTextColor(Color.GRAY);
        }
        else
        {
            tabOne.setTextColor(Color.GRAY);
            tabTwo.setTextColor(Color.GRAY);
            tabThree.setTextColor(Color.GRAY);
            tabfour.setTextColor(Color.BLACK);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_detail_layout,menu);
        return true;
    }
}
