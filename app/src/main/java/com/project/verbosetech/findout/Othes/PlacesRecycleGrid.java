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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.verbosetech.findout.Models.Places;
import com.project.verbosetech.findout.R;

import java.util.List;

/**
 * Created by this pc on 07-06-17.
 */

public class PlacesRecycleGrid extends RecyclerView.Adapter<PlacesRecycleGrid.MyHolder> implements View.OnClickListener {

    public RecyclerView re;
    private List<Places> dataSet ;
    public Context context=null;
    VenueAdapterClickCallbacks venueAdapterClickCallbacks;
    String image_address="http://healthyrise.com/wp-content/uploads/2016/06/Restaurant-Food-11.jpg";
    int current;

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.share:

                venueAdapterClickCallbacks.onShareClick(dataSet.get(current).getName());
                break;

            case R.id.phone:

                venueAdapterClickCallbacks.onCallClick("7049575274");
                break;
        }

    }


    public class MyHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView address;
        TextView distance;
        ImageView image,share,call;
        RatingBar ratingBar;

        public MyHolder(View itemView)
        {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.place_name);
            this.address = (TextView) itemView.findViewById(R.id.place_add);
            this.distance=(TextView)itemView.findViewById(R.id.distance);
            this.image=(ImageView)itemView.findViewById(R.id.res_image);
            this.ratingBar=(RatingBar)itemView.findViewById(R.id.rating_bar);
            this.share=(ImageView)itemView.findViewById(R.id.share);
            this.call=(ImageView)itemView.findViewById(R.id.phone);
        }
    }

    public PlacesRecycleGrid(Context c, List<Places> data, VenueAdapterClickCallbacks venueAdapterClickCallback)
    {

        this.dataSet = data;
        this.venueAdapterClickCallbacks=venueAdapterClickCallback;
        context=c;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_specific_layout, parent, false);
        MyHolder myNewsHolder=new MyHolder(view);
        re = (RecyclerView) parent.findViewById(R.id.place_recycle_grid);
        return myNewsHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        TextView name = holder.name;
        TextView address = holder.address;
        TextView distance = holder.distance;
        ImageView image=holder.image;
        RatingBar ratingBar=holder.ratingBar;
        ImageView share=holder.share;
        ImageView call=holder.call;
        name.setText(dataSet.get(position).getName());

        address.setText(dataSet.get(position).getAddress());
        distance.setText(dataSet.get(position).getDistance());

        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_ATOP);

        Glide.with(context).load(R.drawable.images_restaurant)
                .dontAnimate()
                .centerCrop()
                .override(500,500)
                .bitmapTransform(new RoundedCornersTransformation(context,10,0, RoundedCornersTransformation.CornerType.TOP))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                venueAdapterClickCallbacks.onCardClick(dataSet.get(position).getName());

            }
        });

        current=holder.getLayoutPosition();
        share.setOnClickListener(this);
        call.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface VenueAdapterClickCallbacks {
        void onCardClick( String p);
        void onShareClick(String p);
        void onCallClick(String p);

    }


}

