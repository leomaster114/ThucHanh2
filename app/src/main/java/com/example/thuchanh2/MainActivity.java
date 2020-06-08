package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Fragment1.ItemClicked {
    ImageView anh;
    TextView nuocdi;
    ArrayList<Integer> images;
    String[] nuoc_di;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh = findViewById(R.id.imgv);
        nuocdi = findViewById(R.id.textview);

       nuoc_di = getResources().getStringArray(R.array.nuoc_di);
        images = image.images();

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment1 = manager.findFragmentById(R.id.fragment1);
        Fragment fragment2 = manager.findFragmentById(R.id.fragment2);

        manager.beginTransaction().show(fragment1).hide(fragment2).commit();

    }

    @Override
    public void itemClick(int position) {
        anh.setImageResource(images.get(position));
        nuocdi.setText(nuoc_di[position]);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment1 = manager.findFragmentById(R.id.fragment1);
        Fragment fragment2 =  manager.findFragmentById(R.id.fragment2);

        manager.beginTransaction().show(fragment2).hide(fragment1).addToBackStack(null).commit();
    }
}
