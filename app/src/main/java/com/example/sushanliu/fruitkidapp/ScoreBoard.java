package com.example.sushanliu.fruitkidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScoreBoard extends AppCompatActivity {

    private Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        playAgain = (Button)findViewById(R.id.btn_palyAgain);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        });

    }

    public void openGame(){
        Intent intent = new Intent(this, LevelSelectingActivity.class);
        startActivity(intent);
    }
}
