package com.naserkarimi.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrayList.add("");
        }
        RecyclerView animationRecyclerView = findViewById(R.id.animationRecyclerView);
        animationRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        animationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arrayList, getIntent().getIntExtra("type", 1));
        animationRecyclerView.setAdapter(recyclerViewAdapter);
    }
}