package com.example.picture_match.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.picture_match.R;

public class MainActivity extends AppCompatActivity {
    TextView no_time_limit,normal,hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no_time_limit=findViewById(R.id.no_time_limit);
        normal=findViewById(R.id.normal);
        hard=findViewById(R.id.hard);

        no_time_limit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Level_Listview_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}