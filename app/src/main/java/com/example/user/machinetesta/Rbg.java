package com.example.user.machinetesta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Rbg extends AppCompatActivity {
    Button proceed, redbtn, bluebtn, grnbtn;
    String color = "";
    LinearLayout r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbg);
        redbtn = findViewById(R.id.red);
        bluebtn = findViewById(R.id.blue);
        grnbtn = findViewById(R.id.green);
        r1 = findViewById(R.id.ll);
        proceed = findViewById(R.id.proceed1);
    }

    public void proceed(View view) {
        Intent i = new Intent(Rbg.this, Login.class);
        if (color.equals("")) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(Rbg.this, Login.class);
            SharedPreferences shred = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
            SharedPreferences.Editor edit = shred.edit();
            edit.putString("key", color);
            edit.apply();
            startActivity(i);

        }


        }

        public void redclick (View view){
            r1.setBackgroundResource(R.color.Red);
            color = "Red";
        }

        public void blueclick (View view){
            r1.setBackgroundResource(R.color.Blue);
            color = "Blue";
        }


        public void greenclick (View view){
            r1.setBackgroundResource(R.color.Green);
            color = "Green";
        }
    }

