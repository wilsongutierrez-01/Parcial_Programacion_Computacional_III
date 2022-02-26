package com.gutierrez.week2_basic_controls;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveData extends AppCompatActivity {
    Button btn;
    String name, lastname;
    Integer Age;
    TextView tempVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        receivingData();
        showData();

        btn = findViewById(R.id.btnBack);
        btn.setOnClickListener(v ->{
            sendB();
        });

    }

    //**********Go Back******************************
    private void sendB (){
        Bundle extras = new Bundle();
        extras.putString("sendName", name);
        extras.putString("sendLastName", " ");
        Intent sendB = new Intent(getApplicationContext(), SendData.class);
        sendB.putExtras(extras);
        startActivity(sendB);
    }

    //*********************************Conditions and Show data*********************
    private void showData (){
        tempVal = findViewById(R.id.iname);
        tempVal.setText(getString(R.string.iname) +" " + name);
        tempVal = findViewById(R.id.ilastname);
        tempVal.setText(getString(R.string.ilastname) +" " + lastname);
        tempVal = findViewById(R.id.iage);
        tempVal.setText(getString(R.string.iAge) +" " + Age.toString());

        tempVal = findViewById(R.id.condition);
        if (Age >= 18){
            tempVal.setText(getString(R.string.higher));
        }else{
            tempVal.setText(getString(R.string.less));
        }
    }

    //******************************Receive Data*************************************
    private void receivingData (){
        Bundle rData = this.getIntent().getExtras();
        name = rData.getString("rName");
        lastname = rData.getString("rLastName");
        Age = rData.getInt("rAge");
    }
}