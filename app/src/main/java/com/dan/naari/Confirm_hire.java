package com.dan.naari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Confirm_hire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_hire);
    }

    public void receipt(View v){
        Intent implicit = new Intent(Confirm_hire.this, Receipt.class);
        startActivity(implicit);
        /*Toast.makeText(getApplicationContext(),"You have hired a normal ambulance," +
                "Please pay via MPESA or Airtel-Money or cash when the ambulance arrives",Toast.LENGTH_LONG).show();*/


    }
}