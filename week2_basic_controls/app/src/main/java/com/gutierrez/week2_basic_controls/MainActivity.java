package com.gutierrez.week2_basic_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   TextView tmpVal;
    Button btnSend;
 public  String name, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LINKING THE VARIABLES
        btnSend = findViewById(R.id.btnSend);



        //Code
        try{
            btnSend.setOnClickListener(v ->{
                captureData();
                SendActivity();
            });

        }catch(Exception e){
            mostrarMsgToast(e.getMessage());
        }


    }

    private void captureData (){
        tmpVal = findViewById(R.id.txtName);
        name = tmpVal.getText().toString();
        Globals.setThisname(name);

        tmpVal = findViewById(R.id.txtLastName);
        lastname = tmpVal.getText().toString();

        Globals.setThislastname(lastname);


    }

    private void SendActivity (){
        try {
            Intent send = new Intent(getApplicationContext(), SendData.class);
            startActivity(send);
        }catch(Exception e){
            mostrarMsgToast(e.getMessage());
        }
;
    }

    private void mostrarMsgToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }



}