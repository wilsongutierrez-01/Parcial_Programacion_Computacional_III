package com.gutierrez.week2_basic_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SendData extends AppCompatActivity {
    Button btn;
    TextView tempVal;
    String name, lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        rData();

        tempVal = findViewById(R.id.txtNameC);
        tempVal.setText(name);




        btn = findViewById(R.id.btnSendC);
        btn.setOnClickListener(v -> {
            receiveA();
        });

        btn = findViewById(R.id.btnBack);
        btn.setOnClickListener(v -> {
            goBackMainActivity();
        });

    }

    //*******************Move on receive data*************************************
    private void receiveA (){
        tempVal = findViewById(R.id.txtAge);
        Integer age = Integer.parseInt(tempVal.getText().toString());
        Bundle rData = new Bundle();
        rData.putString("rName", name);
        rData.putString("rLastName", lastname);
        rData.putInt("rAge", age);
        Intent receiveA = new Intent(getApplicationContext(), ReceiveData.class);
        receiveA.putExtras(rData);
        startActivity(receiveA);
    }

    //*******************Move on Main Activity************************************
    private void goBackMainActivity (){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }

    //****************Receive data********************************
    private void rData(){
        Bundle rData = this.getIntent().getExtras();
         name = rData.getString("sendName");
         lastname = rData.getString("sendLastName");
    }
}