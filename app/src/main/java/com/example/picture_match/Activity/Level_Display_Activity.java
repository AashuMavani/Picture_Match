package com.example.picture_match.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picture_match.Adapter.Config;
import com.example.picture_match.Adapter.Level_display_Adapter;
import com.example.picture_match.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level_Display_Activity extends AppCompatActivity {
    GridView level_gridview;
    ImageView back;
    TextView timeshow;
    int column;
    // ArrayList imgarr=new ArrayList();
    private ArrayList<String> imgArr=new ArrayList<>();
    private List<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_display);
        level_gridview=findViewById(R.id.level_gridview);
        back=findViewById(R.id.back);
        timeshow=findViewById(R.id.timeshow);
        int levelno=getIntent().getIntExtra("levelno",1);


        String[] images = new String[0];
        try {
            images = getAssets().list("images");
            imgArr = new ArrayList<String>(Arrays.asList(images));
            imgArr.remove("android-logo-mask.png");
            imgArr.remove("android-logo-shine.png");
            imgArr.remove("clock_font.png");
            imgArr.remove("progress_font.png");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(levelno==1)
        {
            arrayList= imgArr.subList(0,6);
            column=3;
        }
        if(levelno==2)
        {
            arrayList=imgArr.subList(0,8);
            column=4;
        }
        if (levelno==3)
        {
            arrayList=imgArr.subList(0,10);
            column=5;
        }

        arrayList.addAll(arrayList);
        Collections.shuffle(arrayList);
        Level_display_Adapter adapter=new Level_display_Adapter(Level_Display_Activity.this, arrayList);
        level_gridview.setNumColumns(column);
        level_gridview.setAdapter(adapter);
    }
}