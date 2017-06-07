package com.project.verbosetech.findout.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.project.verbosetech.findout.Othes.CustomGridAdapter;
import com.project.verbosetech.findout.Othes.CustomPagerAdapter;
import com.project.verbosetech.findout.Othes.Pager;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by this pc on 06-06-17.
 */

public class ViewPagerDemo extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    int[] mResources = {R.drawable.images_banner, R.drawable.images_banner, R.drawable.images_banner};

    Pager mViewPager;
    private CustomPagerAdapter mAdapter;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    GridView gridView;
    CustomGridAdapter customGridAdapter;
    ArrayList<String> place;
    ArrayList<Integer> image;
    ArrayList<String> number;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (Pager) findViewById(R.id.viewpager);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        mAdapter = new CustomPagerAdapter(this, mResources);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(this);
        gridView=(GridView)findViewById(R.id.grid_view);
        setPageViewIndicator();
        setGridItems();

    }

    private void setPageViewIndicator() {

        Log.d("###setPageViewIndicator", " : called");
        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mViewPager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Log.d("###onPageSelected, pos ", String.valueOf(position));
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setGridItems(){


        place=new ArrayList<>();
        image=new ArrayList<>();
        number=new ArrayList<>();
        place.add("Restaurant");
        place.add("Restaurant");
        place.add("Restaurant");
        place.add("Restaurant");
        place.add("Restaurant");
        place.add("Restaurant");
        image.add(R.drawable.images_restaurant);
        image.add(R.drawable.images_gym);
        image.add(R.drawable.images_interior);
        image.add(R.drawable.images_gym);
        image.add(R.drawable.images_interior);
        image.add(R.drawable.images_gym);
        number.add("85");
        number.add("45");
        number.add("65");
        number.add("25");
        number.add("65");
        number.add("25");
        customGridAdapter=new CustomGridAdapter(getApplicationContext(),place,number,image);
        gridView.setAdapter(customGridAdapter);
    }
}