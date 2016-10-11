package com.yafengxiong.fblamobileapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by juanr on 10/10/2016.
 */

public class ImageAdapter extends BaseAdapter{
    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }
    public int getCount(){
        return mThumbIds.length;
    }
    public Object getItem(int position){
        //TODO: return item
        return null;
    }
    public long getItemId(int position){
        //TODO: return item id
        return 0;
    }

    //Create a new ImageView for each item referenced by the adapter
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null) {
            //if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    //reference images
    private Integer[] mThumbIds = {}; //TODO: add images in this array, create getter and setter methods for this purpose
}

