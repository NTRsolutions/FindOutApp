package com.project.verbosetech.findout.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.project.verbosetech.findout.Activity.ListOfPlacesActivity;
import com.project.verbosetech.findout.Models.GridCardModel;
import com.project.verbosetech.findout.Othes.CustomGridAdapter;
import com.project.verbosetech.findout.Othes.CustomPagerAdapter;
import com.project.verbosetech.findout.Othes.Pager;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 08-06-17.
 */

public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private View view;
    int[] mResources = {R.drawable.images_banner, R.drawable.banner2, R.drawable.banner3};
    String tag[]={"Share with your\nloved ones and get","Explore the new destinations..\nFind a traveler","Find any services\non your fingertips"};
    String buttons[]={"50 Rs.Paytm","Find now","Search"};

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
    List<GridCardModel> gridCardModelList;
    String image_address="http://healthyrise.com/wp-content/uploads/2016/06/Restaurant-Food-11.jpg";


    HomeFragment.OnHeadlineSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        void onHomeSelected(CustomGridAdapter a);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (HomeFragment.OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_view_pager,container,false);
        mViewPager = (Pager) view.findViewById(R.id.viewpager);
        pager_indicator = (LinearLayout) view.findViewById(R.id.viewPagerCountDots);
        mAdapter = new CustomPagerAdapter(getActivity(), mResources,tag,buttons);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(this);
        gridView=(GridView)view.findViewById(R.id.grid_view);
        setPageViewIndicator();
        setGridItems();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(getActivity(), ListOfPlacesActivity.class));
            }
        });
        getAdapter();
        return view;
    }

    private void setPageViewIndicator() {

        Log.d("###setPageViewIndicator", " : called");
        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
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

        gridCardModelList=new ArrayList<>();
        gridCardModelList.add(new GridCardModel(image_address,"Restaurant","85"));
        gridCardModelList.add(new GridCardModel(image_address,"Gymnasium","85"));
        gridCardModelList.add(new GridCardModel(image_address,"Home Decor","85"));
        gridCardModelList.add(new GridCardModel(image_address,"Travelers","85"));
        gridCardModelList.add(new GridCardModel(image_address,"Restaurant","85"));
        gridCardModelList.add(new GridCardModel(image_address,"Restaurant","85"));
        customGridAdapter=new CustomGridAdapter(getActivity(),gridCardModelList);
        gridView.setAdapter(customGridAdapter);
    }

    public void getAdapter() {

        mCallback.onHomeSelected(customGridAdapter);
    }
}
