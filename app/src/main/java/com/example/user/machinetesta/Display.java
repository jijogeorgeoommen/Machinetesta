package com.example.user.machinetesta;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    ImageButton logoutbtn;
    EditText namedis, dobdis, genderdis, add1dis, add2dis, phonedis;
    LinearLayout llay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        logoutbtn = findViewById(R.id.logoutid);
        registerForContextMenu(logoutbtn);
        namedis = findViewById(R.id.nameid);
        dobdis = findViewById(R.id.dobid);
        genderdis = findViewById(R.id.genderid);
        add1dis = findViewById(R.id.add1id);
        add2dis = findViewById(R.id.add2id);
        phonedis = findViewById(R.id.phoneid);
        SharedPreferences obj = getApplicationContext().getSharedPreferences("spf", MODE_PRIVATE);
        String namedisstr = obj.getString("key1", null);
        String dobdisstr = obj.getString("key2", null);
        String genderdisstr = obj.getString("key6", null);
        String add1disstr = obj.getString("key3", null);
        String add2disstr = obj.getString("key4", null);
        String phonedisstr = obj.getString("key5", null);
        namedis.setText(namedisstr);
        dobdis.setText(dobdisstr);
        genderdis.setText(genderdisstr);
        add1dis.setText(add1disstr);
        add2dis.setText(add2disstr);
        phonedis.setText(phonedisstr);
        SharedPreferences shred = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        String clr1 = shred.getString("key", null);
        llay3 = findViewById(R.id.ll3);
        if (clr1.equals("Red")) {
            llay3.setBackgroundResource(R.color.Red);
        } else if (clr1.equals("Blue")) {
            llay3.setBackgroundResource(R.color.Blue);
        } else if (clr1.equals("Green")) {
            llay3.setBackgroundResource(R.color.Green);
        }

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Message");
        menu.add(0, v.getId(), 0, "Logout");
        menu.add(0, v.getId(), 0, "Delete Account");
        menu.add(0, v.getId(), 0, "Exit App");

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Logout") {

            AlertDialog.Builder AB = new AlertDialog.Builder(Display.this);
            AB.setMessage("Do you really want to Log-out").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog A = AB.create();
            A.setTitle("EXIT SCREEN");
            A.show();
            // super.onBackPressed();
        }
       else if (item.getTitle() == "Delete Account") {
            SharedPreferences obj = getApplicationContext().getSharedPreferences("spf", MODE_PRIVATE);
            SharedPreferences.Editor edt = obj.edit();
            edt.clear();
            edt.apply();
            finish();
        }
        else if (item.getTitle()=="Exit App"){
            finishAffinity();

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mes) {
            Intent i = new Intent(Display.this, Camopt.class);
            startActivity(i);
        } else if (id == R.id.cal) {
            Intent c = new Intent(Display.this, Calculator.class);
            startActivity(c);
        }
            return super.onOptionsItemSelected(item);
        }
    }













