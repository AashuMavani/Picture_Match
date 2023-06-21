package com.example.picture_match.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picture_match.Adapter.Config;
import com.example.picture_match.Adapter.Level_display_Adapter;
import com.example.picture_match.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level_Display_Activity extends AppCompatActivity {
    GridView level_gridview;
    ImageView back;
    TextView timeshow,leveltype1;

    ProgressBar progressBar;
    String level;

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
        progressBar=findViewById(R.id.progressBar);
        leveltype1=findViewById(R.id.leveltype1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Level_Display_Activity.this,Level_Listview_Activity.class);
                startActivity(intent);
            }
        });

       int  levelno=getIntent().getIntExtra("levelno",1);
            level=getIntent().getStringExtra("level");
            leveltype1.setText(level);

       MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(Level_Display_Activity.this);
       builder.setTitle("TIME:NO TIME LIMIT");
       builder.setMessage("YOU HVAE % SECONDS TO MEMORIZE ALL IMAGES");
       builder.setPositiveButton("GO", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

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
               if(levelno<=3)
               {
                   arrayList= imgArr.subList(0,6);
                   column=3;
               }
               if(levelno>3&&levelno<=5)
               {
                   arrayList=imgArr.subList(0,8);
                   column=4;
               }
               if (levelno>5&&levelno<=7)
               {
                   arrayList=imgArr.subList(0,10);
                   column=5;
               }
               if (levelno>7&&levelno<=10)
               {
                   arrayList=imgArr.subList(0,12);
                   column=6;
               }

               arrayList.addAll(arrayList);

               Collections.shuffle(arrayList);
               Level_display_Adapter adapter=new Level_display_Adapter(Level_Display_Activity.this, arrayList,progressBar,timeshow,level);
               level_gridview.setNumColumns(column);
               level_gridview.setAdapter(adapter);
           }
       }).show();


    }
}