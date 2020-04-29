package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class backend extends AppCompatActivity {
Button storefrontbutton,add;
Databasehelper databasehelper;
ListView listView_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backend);
        storefrontbutton=(Button)findViewById(R.id.store_front);
        add=(Button)findViewById(R.id.add);
        listView_add=(ListView)findViewById(R.id.list_add);
        databasehelper=new Databasehelper(this);
        populateListView();
        storefrontbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(backend.this,MainActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(backend.this,Add_item.class);
                startActivity(intent);
            }
        });
    }
    public void populateListView() {
        //get the data and append to a list
        Cursor data = databasehelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getPosition() + 1 + " | "+data.getString(1)+" | price: "+data.getString(2));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView_add.setAdapter(adapter);
    }
}
