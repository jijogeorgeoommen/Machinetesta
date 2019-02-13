package com.example.user.machinetesta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText namein,pasin;
String nameinstr;
LinearLayout llay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        namein=findViewById(R.id.usernamein);
        pasin=findViewById(R.id.passin);
        SharedPreferences shred = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        String clr1 = shred.getString("key", null);
        llay2 = findViewById(R.id.ll2);
        if (clr1.equals("Red")) {
            llay2.setBackgroundResource(R.color.Red);
        } else if (clr1.equals("Blue")) {
            llay2.setBackgroundResource(R.color.Blue);
        } else if (clr1.equals("Green")) {
            llay2.setBackgroundResource(R.color.Green);
        }


    }

    @Override
    protected void onResume() {
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        String nameinstr=obj.getString("key1",null);
        namein.setText(nameinstr);
        String pasinstr=obj.getString("key7",null);
        pasin.setText(pasinstr);
        super.onResume();
    }

    public void register(View view) {
        Intent i=new Intent(Login.this,Register.class);
        startActivity(i);
    }

    public void loginoc(View view) {
        String nameinstr=namein.getText().toString();
        String pasinstr=pasin.getText().toString();   //
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        String name1str=obj.getString("key1",null);
        String pass1str=obj.getString("key7",null);
//        name1.setText(name1str);
//        pass1.setText(pass1str);

        if(nameinstr.equals("") )
        {
//            Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show();
            namein.setError("enter email");
        }
        else if (pasinstr.equals("")) {
            pasin.setError("enter password");

        }
       else if (nameinstr.equals(name1str)&&pasinstr.equals(pass1str)){
            Intent a=new Intent(Login.this,Display.class);

            startActivity(a);

        }
        else {
            Toast.makeText(this, "invalid username/password...", Toast.LENGTH_SHORT).show();
        }


    }

    public void signupoc(View view) {
        Intent i=new Intent(Login.this,Register.class);
        startActivity(i);
    }
}
