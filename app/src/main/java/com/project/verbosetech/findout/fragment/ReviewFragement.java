package com.project.verbosetech.findout.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.project.verbosetech.findout.model.Review;
import com.project.verbosetech.findout.other.ReviewRecycleGrid;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 08-06-17.
 */

public class ReviewFragement extends Fragment {

    private View view;
    private RecyclerView.LayoutManager layoutManager;
    ReviewRecycleGrid adapter;
    RecyclerView recyclerView;
    List<Review> reviewList;
    RatingBar ratingBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.review_layout,container,false);
        ratingBar=(RatingBar)view.findViewById(R.id.rating_bar);

        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_ATOP);

        recyclerView=(RecyclerView)view.findViewById(R.id.review_grid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getReviewCards();
        return view;
    }

    public void getReviewCards(){

        reviewList=new ArrayList<>();
        reviewList.add(new Review("Rajesh Shah","21st March,2014","5.0"));
        reviewList.add(new Review("Rajesh Shah","21st March,2014","5.0"));
        reviewList.add(new Review("Rajesh Shah","21st March,2014","5.0"));
        reviewList.add(new Review("Rajesh Shah","21st March,2014","5.0"));
        adapter=new ReviewRecycleGrid(getActivity(),reviewList);
        recyclerView.setAdapter(adapter);
    }
}
