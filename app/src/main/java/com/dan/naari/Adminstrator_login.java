package com.dan.naari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Adminstrator_login extends AppCompatActivity {
 private Button login;
 private TextInputLayout email,pass;
 private final String admin_email = "admin@gmail.com";
 private final String admin_pass = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminstrator_login);

        login = findViewById(R.id.login_user_btn);
        email = findViewById(R.id.login_username);
        pass = findViewById(R.id.login_pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Administrator_home.class);
                startActivity(i);

                //Toast.makeText(getApplicationContext(), "You are not admin", Toast.LENGTH_SHORT).show();


            }
        });

    }




}




