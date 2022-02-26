package com.gutierrez.week2_basic_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView temVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(v->{
            sendA();
        });

     
    }

    //*****Open activity and send data*****************************

    private void sendA(){
        temVal = findViewById(R.id.txtName);
        String name = temVal.getText().toString();
        temVal = findViewById(R.id.txtLastName);
        String lastName = temVal.getText().toString();
        try{
            Bundle extras = new Bundle();
            extras.putString("sendName", name);
            extras.putString("sendLastName", lastName);
            Intent sendA = new Intent(getApplicationContext() ,SendData.class );
            sendA.putExtras(extras);
            startActivity(sendA);
        }catch(Exception e){
            MessageToast(e.getMessage());
        }


    }

    //*****************TOAST MESSAGE**********************************************

    private void MessageToast (String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}