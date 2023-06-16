package com.example.picture_match.Adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.picture_match.Activity.Level_Display_Activity;
import com.example.picture_match.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level_display_Adapter extends BaseAdapter {
    Level_Display_Activity level_display_activity;
    List arrayList=new ArrayList<>();


    int i=-1;
    public Level_display_Adapter(Level_Display_Activity level_display_activity, List arrayList) {
        this.level_display_activity=level_display_activity;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(level_display_activity).inflate(R.layout.level_gridview_item,parent,false);
        ImageView imageView=view.findViewById(R.id.img_disp);

        Log.d("MMM", "getView: List="+arrayList);
        InputStream inputStream = null;
        try {
            inputStream = level_display_activity.getAssets().open("images/" + arrayList.get(position));
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
            inputStream.close();
            Log.d("MMM", "getView: Position="+position);

        } catch (IOException e) {
            new RuntimeException(e);
        }
        return view;
    }
}
