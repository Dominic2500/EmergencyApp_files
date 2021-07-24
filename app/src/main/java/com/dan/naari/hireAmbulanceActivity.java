package com.dan.naari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class hireAmbulanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_by);
    }

    public void Dan(View v){
        Intent implicit = new Intent(hireAmbulanceActivity.this, Confirm_hire.class);
        startActivity(implicit);
        /*Toast.makeText(getApplicationContext(),"You have hired a normal ambulance," +
                "Please pay via MPESA or Airtel-Money or cash when the ambulance arrives",Toast.LENGTH_LONG).show();*/


    }

    public void Ary(View v){
        //Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aryanveturekar.github.io/"));
       // startActivity(implicit);
       /* Toast.makeText(getApplicationContext(),"You have hired a Medium ambulance," +
                "Please pay via MPESA or Airtel-Money or cash when the ambulance arrives",Toast.LENGTH_LONG).show();*/
        Intent implicit = new Intent(hireAmbulanceActivity.this, Confirm_hire.class);
        startActivity(implicit);

    }

    public void Him(View v){
        //Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://himanshusiingh.github.io/"));
       // startActivity(implicit);
        /*Toast.makeText(getApplicationContext(),"You have hired a Delux ambulance," +
                "Please pay via MPESA or Airtel-Money or cash when the ambulance arrives",Toast.LENGTH_LONG).show();*/
        Intent implicit = new Intent(hireAmbulanceActivity.this, Confirm_hire.class);
        startActivity(implicit);

    }
}
