package com.project.verbosetech.findout.Othes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.project.verbosetech.findout.Models.Review;
import com.project.verbosetech.findout.R;

import java.util.List;

/**
 * Created by this pc on 09-06-17.
 */

public class ReviewRecycleGrid extends RecyclerView.Adapter<ReviewRecycleGrid.MyHolder>{

    public RecyclerView re;
    private List<Review> dataSet ;
    public Context context=null;


    public class MyHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView date;
        TextView rating;
        ImageView image;
        RatingBar ratingBar;

        public MyHolder(View itemView)
        {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.date = (TextView) itemView.findViewById(R.id.date);
            this.rating=(TextView)itemView.findViewById(R.id.rating);
            this.image=(ImageView)itemView.findViewById(R.id.user_image);
            this.ratingBar=(RatingBar)itemView.findViewById(R.id.rating_bar);
        }
    }

    public ReviewRecycleGrid(Context c, List<Review> data)
    {

        this.dataSet = data;
        context=c;

    }

    @Override
    public ReviewRecycleGrid.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_rating_info_layout, parent, false);
        ReviewRecycleGrid.MyHolder myHolder=new ReviewRecycleGrid.MyHolder(view);
        re = (RecyclerView) parent.findViewById(R.id.review_grid);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(ReviewRecycleGrid.MyHolder holder, final int position) {

        TextView name = holder.name;
        TextView date = holder.date;
        TextView rating = holder.rating;
        ImageView image=holder.image;
        RatingBar ratingBar=holder.ratingBar;

        name.setText(dataSet.get(position).getName());
        date.setText(dataSet.get(position).getDate());
        rating.setText(dataSet.get(position).getRating());
        image.setImageResource(R.drawable.ic_usermini);

        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_ATOP);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
