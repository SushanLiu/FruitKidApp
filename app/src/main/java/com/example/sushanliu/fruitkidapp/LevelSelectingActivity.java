package com.example.sushanliu.fruitkidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelectingActivity extends AppCompatActivity {

    private Button btnEasy, btnMaster;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selecting);

        btnEasy = (Button)findViewById(R.id.btn_easy);
        btnMaster=(Button)findViewById(R.id.btn_master);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });
    }

    public void openGameActivity(){
        Intent intentEasyGame=new Intent(this,ValueBoard.class);
        startActivity(intentEasyGame);
    }

}
