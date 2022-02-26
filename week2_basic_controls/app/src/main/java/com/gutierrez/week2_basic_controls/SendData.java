package com.gutierrez.week2_basic_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SendData extends AppCompatActivity {
    // for reading text
     TextView txtName, txtAge;
     ////////////////////////////////////////
     public Double age;
     ///////////////////////////////////////


     String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        txtName = findViewById(R.id.txtNameC);
        txtAge = findViewById(R.id.txtAge);
        age = Double.parseDouble(txtAge.getText().toString());

        //name = Globals.getThisname();
       // txtName.setText(name);




    }
}