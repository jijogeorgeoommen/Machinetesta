package com.example.user.machinetesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread bg=new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(MainActivity.this, Rbg.class);
                    startActivity(i);
                    finish();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        };
        bg.start();
    }
}
