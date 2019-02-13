package com.example.user.machinetesta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity {
 EditText datetxt,namereg,ad1reg,ad2reg,phnereg,pasreg;
 RadioGroup radiogroup;
 RadioButton genderbtn;
 String gender;
 ScrollView sv;

    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        datetxt=findViewById(R.id.agereg);
        namereg=findViewById(R.id.usernamereg);
        ad1reg=findViewById(R.id.add1reg);
        ad2reg=findViewById(R.id.add2reg);
        phnereg=findViewById(R.id.phonereg);
        pasreg=findViewById(R.id.passreg);
        radiogroup=findViewById(R.id.rgroup);
        sv = findViewById(R.id.sv1);
        SharedPreferences shred = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        String clr1 = shred.getString("key", null);
        if (clr1.equals("Red")) {
            sv.setBackgroundResource(R.color.Red);
        } else if (clr1.equals("Blue")) {
            sv.setBackgroundResource(R.color.Blue);
        } else if (clr1.equals("Green")) {
            sv.setBackgroundResource(R.color.Green);
        }
    }

    public void regbtn(View view) {
        String nameregstr=namereg.getText().toString();
        String dobstr=datetxt.getText().toString();
        String add1str=ad1reg.getText().toString();
        String add2str=ad2reg.getText().toString();
        String phnestr=phnereg.getText().toString();
        String passregstr=pasreg.getText().toString();
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        SharedPreferences.Editor edt=obj.edit();
        edt.putString("key1",nameregstr);
        edt.putString("key2",dobstr);
        edt.putString("key3",add1str);
        edt.putString("key4",add2str);
        edt.putString("key5",phnestr);
        edt.putString("key6",gender);
        edt.putString("key7",passregstr);
        edt.apply();

        final int selectId=radiogroup.getCheckedRadioButtonId();
        genderbtn=findViewById(selectId);
        if (selectId==-1)
        {
            Toast.makeText(this, "nothing selected", Toast.LENGTH_SHORT).show();
        }
        else {
         genderbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String gender=genderbtn.getText().toString();
             }
         });

        }
        Intent i=new Intent(Register.this,Login.class);
        if (nameregstr.equals("")){
            namereg.setError("Enter Username");
        }
        else if (dobstr.equals("")){
            datetxt.setError("Enter DOB");
            }
         else if (add1str.equals("")){
            ad1reg.setError("Enter address line 1");
        }
        else if (add2str.equals("")){
            ad2reg.setError("Enter address line 2");
        }
        else if (phnestr.equals("")){
            phnereg.setError("Enter phone no.");
        }
        else if (passregstr.equals("")){
            pasreg.setError("Enter password");
        }
        else{
            startActivity(i);
        }

    }


    public void dobbtn(View view) {
        final Calendar c=Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                datetxt.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

            }
        }, mYear, mMonth, mDay);
        dpd.show();

    }
}
