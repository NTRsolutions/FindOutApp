package com.project.verbosetech.findout.Othes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.verbosetech.findout.Models.GridCardModel;
import com.project.verbosetech.findout.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 06-06-17.
 */

public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;
    int images[]={R.drawable.images_restaurant,R.drawable.images_gym,R.drawable.images_interior,R.drawable.images_tourntravels,R.drawable.images_restaurant,R.drawable.images_restaurant};
    List<GridCardModel> dataSet;

    public CustomGridAdapter(Context mContext, List<GridCardModel> dataSet) {
        this.mContext = mContext;
        this.dataSet=dataSet;
    }

    @Override
    public int getCount() {

        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.places_card_layout, null);
            TextView tplace = (TextView) grid.findViewById(R.id.place);
            TextView tnumber = (TextView) grid.findViewById(R.id.number);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
            tplace.setText(dataSet.get(position).getName());
            tnumber.setText(dataSet.get(position).getNumber());

            Glide.with(mContext).load(images[position])
                    .dontAnimate()
                    .centerCrop()
                    .override(500,500)
                    .bitmapTransform(new RoundedCornersTransformation(mContext,50,0, RoundedCornersTransformation.CornerType.TOP))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
        else {

            grid = (View) convertView;
        }

        return grid;
    }

    private void setImageoncard(Context context, ImageView img, String url) {
        Picasso.with(context)
                .load(url)
                .fit()
                .centerCrop()
                .into(img);
    }

    public void setFilter(List<GridCardModel> Model) {
        dataSet = new ArrayList<>();
        dataSet.addAll(Model);
        notifyDataSetChanged();
    }
}
