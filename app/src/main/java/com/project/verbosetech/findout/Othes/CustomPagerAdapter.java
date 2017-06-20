package com.project.verbosetech.findout.Othes;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.verbosetech.findout.R;

/**
 * Created by this pc on 06-06-17.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mResources;
    String[] tag;
    String[] buttons;

    public CustomPagerAdapter(Context mContext, int[] mResources,String[] tag,String[] buttons) {
        this.mContext = mContext;
        this.mResources = mResources;
        this.tag=tag;
        this.buttons=buttons;
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView textView1=(TextView)itemView.findViewById(R.id.tag);
        TextView textView2=(TextView)itemView.findViewById(R.id.text2);

        imageView.setImageResource(mResources[position]);
        textView1.setText(tag[position]);
        textView2.setText(buttons[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
