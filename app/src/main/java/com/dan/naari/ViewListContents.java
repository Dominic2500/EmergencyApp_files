package com.dan.naari;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class ViewListContents extends AppCompatActivity {

    DatabaseHelper2 myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlistcontents_layout);

        final ListView listView = findViewById(R.id.listView);
        myDB = new DatabaseHelper2(this);

        //populate an ArrayList<String> from the database and then view it
        final ArrayList<String> theList = new ArrayList<>();
        //Cursor data = myDB.getListContents();
        Cursor data = myDB.getAllData();
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }


    }
}
