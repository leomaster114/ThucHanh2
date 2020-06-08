package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class SharedPreferenceActivity extends AppCompatActivity {
    TextView tvchange;
    LinearLayout linearLayout;
    int textSize = 32;
    int color = Color.RED;
    Random rnd = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        tvchange = findViewById(R.id.tv_change);
        linearLayout = findViewById(R.id.linearLayout);
        final SharedPreferenceManager preferenceManager = SharedPreferenceManager.getInstance(this);
        if(preferenceManager.getData("textsize")!=-1){
            textSize = preferenceManager.getData("textsize");
            color = preferenceManager.getData("color");
        }
        tvchange.setTextSize(textSize);
        linearLayout.setBackgroundColor(color);
        tvchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceManager.Clear();
                int random = rnd.nextInt(31) + 10;
                tvchange.setTextSize(random);
                color =  Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                linearLayout.setBackgroundColor(color);
                preferenceManager.saveData(random,color);
            }
        });
    }
}
