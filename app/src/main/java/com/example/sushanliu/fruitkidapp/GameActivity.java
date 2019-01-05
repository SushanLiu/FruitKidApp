package com.example.sushanliu.fruitkidapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button getRb1, getRb2, getRb3, getRb4;
    ImageView iv_fruits;

    List<FruitItem> list;
    Random r;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        r = new Random();
        iv_fruits = (ImageView) findViewById(R.id.iv_fruits);



        getRb1 = (Button) findViewById(R.id.btn_opt1);
        getRb2 = (Button) findViewById(R.id.btn_opt2);
        getRb3 = (Button) findViewById(R.id.btn_opt3);
        getRb4 = (Button) findViewById(R.id.btn_opt4);

        list = new ArrayList<>();


        // add all fruits and names to the list

        for (int i=0; i< new Database().answers.length; i++){
            list.add(new FruitItem(new Database().answers[i],new Database().fruits[i]));
        }

        // shuffle the fruits
        Collections.shuffle(list);

        newQuestion(turn);

        getRb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the answer is correct
                if (getRb1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(GameActivity.this, "Correct!",
                            Toast.LENGTH_SHORT).show();
                    //check if last question
                    if (turn < list.size()) {
                        turn ++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(GameActivity.this, "You finished the game!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GameActivity.this, ScoreBoard.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(GameActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    newQuestion(turn);
                }

            }
        });


        getRb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the answer is correct
                if (getRb2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(GameActivity.this, "Correct!",
                            Toast.LENGTH_SHORT).show();
                    //check if last question
                    if (turn < list.size()) {
                        turn ++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(GameActivity.this, "You finished the game!",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(GameActivity.this, ScoreBoard.class);
                        startActivity(intent);

                    }
                }else {
                    Toast.makeText(GameActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    newQuestion(turn);
                }

            }
        });
        getRb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the answer is correct
                if (getRb3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(GameActivity.this, "Correct!",
                            Toast.LENGTH_SHORT).show();
                    //check if last question
                    if (turn < list.size()) {
                        turn ++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(GameActivity.this, "You finished the game!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GameActivity.this, ScoreBoard.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(GameActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    newQuestion(turn);
                }

            }
        });
        getRb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the answer is correct
                if (getRb4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(GameActivity.this, "Correct!",
                            Toast.LENGTH_SHORT).show();
                    //check if last question
                    if (turn < list.size()) {
                        turn ++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(GameActivity.this, "You finished the game!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GameActivity.this, ScoreBoard.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(GameActivity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                    newQuestion(turn);
                }

            }
        });
    }

    private void newQuestion(int number){
        //set fruit images to the screen
        iv_fruits.setImageResource(list.get(number-1).getImage());

        int correct_answer = r.nextInt(4)+1;
        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correct_answer){
            case 1:
                getRb1.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                }while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                getRb2.setText(list.get(secondButton).getName());
                getRb3.setText(list.get(thirdButton).getName());
                getRb4.setText(list.get(forthButton).getName());

                break;
            case 2:
                getRb2.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                }while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                getRb1.setText(list.get(secondButton).getName());
                getRb3.setText(list.get(thirdButton).getName());
                getRb4.setText(list.get(forthButton).getName());
                break;
            case 3:
                getRb3.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                }while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                getRb2.setText(list.get(secondButton).getName());
                getRb1.setText(list.get(thirdButton).getName());
                getRb4.setText(list.get(forthButton).getName());
                break;

            case 4:
                getRb4.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    forthButton = r.nextInt(list.size());
                }while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                getRb2.setText(list.get(secondButton).getName());
                getRb3.setText(list.get(thirdButton).getName());
                getRb1.setText(list.get(forthButton).getName());
                break;

        }
    }


}

