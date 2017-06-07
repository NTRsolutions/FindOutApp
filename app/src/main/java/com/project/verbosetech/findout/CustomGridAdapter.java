package com.project.verbosetech.findout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by this pc on 06-06-17.
 */

public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;
    private final ArrayList<String> place;
    private final ArrayList<String> number;
    ArrayList<Integer> url;

    public CustomGridAdapter(Context mContext, ArrayList<String> place, ArrayList<String> number, ArrayList<Integer> url) {
        this.mContext = mContext;
        this.place = place;
        this.number = number;
        this.url = url;
    }

    @Override
    public int getCount() {

        return place.size();
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
            tplace.setText(place.get(position));
            tnumber.setText(number.get(position));
            imageView.setImageResource(url.get(position));
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
}
