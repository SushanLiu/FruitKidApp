package com.example.sushanliu.fruitkidapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ValueBoard extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_board);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent valueIntent =new Intent(ValueBoard.this, GameActivity.class);
                startActivity(valueIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }


}
