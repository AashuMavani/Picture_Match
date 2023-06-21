package com.example.picture_match.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picture_match.Adapter.Level_List_Adapter;
import com.example.picture_match.R;

public class Level_Listview_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView back1;
    TextView leveltype;
    String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_listview);
        leveltype=findViewById(R.id.leveltype);

        recyclerView=findViewById(R.id.recyclerview);
        back1=findViewById(R.id.back1);


        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Level_Listview_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        level=getIntent().getStringExtra("level");
        Log.d("AAA", "onCreate: level"+level);

         leveltype.setText(level);
       Level_List_Adapter adapter=new Level_List_Adapter(Level_Listview_Activity.this,level);
        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}