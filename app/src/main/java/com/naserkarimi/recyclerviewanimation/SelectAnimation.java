package com.naserkarimi.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAnimation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_animation);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int type = 0;
        switch (view.getId()) {
            case R.id.button1:
                type = 1;
                break;
            case R.id.button2:
                type = 2;
                break;
            case R.id.button3:
                type = 3;
                break;
            case R.id.button4:
                type = 4;
                break;
            case R.id.button5:
                type = 5;
                break;
        }
        Intent intent = new Intent(SelectAnimation.this, MainActivity.class);
        intent.putExtra("type", type);
        SelectAnimation.this.startActivity(intent);
    }
}