package com.project.verbosetech.findout.Othes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.verbosetech.findout.Models.Places;
import com.project.verbosetech.findout.R;

import java.util.List;

/**
 * Created by this pc on 07-06-17.
 */

public class PlacesRecycleGrid extends RecyclerView.Adapter<PlacesRecycleGrid.MyHolder>{

    public RecyclerView re;
    private List<Places> dataSet ;
    public Context context=null;
    VenueAdapterClickCallbacks venueAdapterClickCallbacks;


    public class MyHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView address;
        TextView distance;
        ImageView image;

        public MyHolder(View itemView)
        {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.place_name);
            this.address = (TextView) itemView.findViewById(R.id.place_add);
            this.distance=(TextView)itemView.findViewById(R.id.distance);
            this.image=(ImageView)itemView.findViewById(R.id.res_image);
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
        name.setText(dataSet.get(position).getName());

        address.setText(dataSet.get(position).getAddress());
        distance.setText(dataSet.get(position).getDistance());
        image.setImageResource(R.drawable.images_restaurant);

//        Glide.with(context).load(image_address)
//                .dontAnimate()
//                .centerCrop()
//                .override(500,500)
//                .bitmapTransform(new RoundedCornersTransformation(context,10,0, RoundedCornersTransformation.CornerType.TOP))
//                .placeholder(R.drawable.placeholder)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                venueAdapterClickCallbacks.onCardClick(dataSet.get(position).getName());

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface VenueAdapterClickCallbacks {
        void onCardClick( String p);

    }


}

