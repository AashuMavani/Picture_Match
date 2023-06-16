package com.example.picture_match.Adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picture_match.Activity.Level_Display_Activity;
import com.example.picture_match.Activity.Level_Listview_Activity;
import com.example.picture_match.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Listview_Adapter extends BaseAdapter {
    Level_Listview_Activity level_listview_activity;
    String levelno[]={"level 1","level 2","level 3","level 4","level 5","level 6","level 7","level 8"};
    List arrayList=new ArrayList<>();

    public Listview_Adapter(Level_Listview_Activity level_listview_activity) {
        this.level_listview_activity=level_listview_activity;
    }


    @Override
    public int getCount() {
        return levelno.length;
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
        view= LayoutInflater.from(level_listview_activity).inflate(R.layout.listview_item,parent,false);
        TextView textView=view.findViewById(R.id.listview_item);

         textView.setText(""+levelno[position]);
        return view;
    }
}
