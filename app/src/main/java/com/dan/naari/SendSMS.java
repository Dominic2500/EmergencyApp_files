package com.dan.naari;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SendSMS extends AppCompatActivity {

    DatabaseHelper2 mydb;
    EditText name,surname,phone,email,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        mydb = new DatabaseHelper2(this);

        name = findViewById(R.id.edit_name);
        surname = findViewById(R.id.edit_sur);
        phone = findViewById(R.id.edit_phone);
        email = findViewById(R.id.edit_email);
        address = findViewById(R.id.edit_address);

  }
  @Override
  protected void onResume() {
      super.onResume();
  }

    public void add(View view){

        String phone_num=phone.getText().toString();
        int l1=name.getText().toString().length(),l2=phone_num.length(),l3=email.getText().toString().length(),l4=address.getText().toString().length();

        if(l1*l2*l3*l4==0)
        {
            show_message("Incomplete data","Enter mandatory fields");
            return;
        }else if(l2!=10){
            show_message("Invalid phone number","Please enter a valid mobile number");
            return;
        }

        Cursor res=mydb.dup_name(phone_num);

        if(res.getCount()!=0)
        {
            show_message("Duplicate Contact","There exists a contact with the same phone number,please change the number");
            return;
        }

        boolean result=mydb.insert_data(name.getText().toString(),surname.getText().toString(),phone.getText().toString(),
                email.getText().toString(),address.getText().toString());
        if(result)
            Toast.makeText(getApplicationContext(),"Data inserted !",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"failed to insert!",Toast.LENGTH_SHORT).show();
    }

    public void show_details(View view){


        cleartext();
        Cursor res=mydb.getAllData();

        if(res.getCount()==0){
            //Toast.makeText(getBaseContext(),"No rows in the table",Toast.LENGTH_SHORT).show();
            show_message("Search result","no rows");
            return;
        }
        Intent intent = new Intent(getApplicationContext(), ViewListContents.class);
        startActivity(intent);

       /* StringBuilder buffer=new StringBuilder();
        while(res.moveToNext()){
            buffer.append("name:\t").append(res.getString(0)).append("\n");
            buffer.append("surname:\t").append(res.getString(1)).append("\n");
            buffer.append("phone:\t").append(res.getString(2)).append("\n");
            buffer.append("email:\t").append(res.getString(3)).append("\n");
            buffer.append("address:\t").append(res.getString(4)).append("\n");
            buffer.append("importance:\t").append(res.getString(5)).append("\n\n");

        }
        show_message("Contacts",buffer.toString());*/
    }

    void show_message(String title,String msg){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();


    }

    public void remove(View view){

        if(phone.getText().toString().length()==0)
        {
            show_message("Invalid operation","Enter the phone number of contact");
            return;
        }
        mydb.remove_data(phone.getText().toString());
        cleartext();
        show_message("Contact Removal","Contact removed if present");


    }

    public void clearme(View view){
        cleartext();
    }
    void cleartext(){
        name.setText("");
        surname.setText("");
        phone.setText("");
        email.setText("");
        address.setText("");
    }

    public void show_hint(View view){   //? image view click
        show_message("Hint","1)Add unique names to contact list\n");

    }

    public void next_page(View view){
        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
        Intent k=new Intent(this,Distress.class);   //go to next page upon saving
        startActivity(k);
    }




}