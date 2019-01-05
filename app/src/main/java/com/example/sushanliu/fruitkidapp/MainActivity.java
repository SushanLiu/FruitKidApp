package com.example.sushanliu.fruitkidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText etName, etPass;
    private CheckBox cblsRememberPass;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    // Button moving
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button) findViewById(R.id.btn_login);
        etName = (EditText) findViewById(R.id.et_name);
        etPass = (EditText) findViewById(R.id.et_pass);
        cblsRememberPass = (CheckBox) findViewById(R.id.cblsRememberpass);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean pang = sharedPreferences.getBoolean("remember_password", false);
        if (pang) {
            etName.setText(sharedPreferences.getString("Name", ""));
            etPass.setText(sharedPreferences.getString("Password", ""));
            cblsRememberPass.setChecked(true);
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                String tempname = etName.getText().toString();
                String temppass = etPass.getText().toString();
                if (tempname.equals("abc") && temppass.equals("1234")) {
                    if (cblsRememberPass.isChecked()) {
                        editor.putString("Name", tempname);
                        editor.putString("Password", tempname);
                        editor.putBoolean("remember_password", true);
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, LevelSelectingActivity.class);
                        startActivity(intent);

                    } else {
                        editor.clear();
                        Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                    }
                    editor.apply();
                }
            }
        });

    }
}
