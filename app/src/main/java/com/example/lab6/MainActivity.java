package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
Button backend_button;
ListView listView;
static Databasehelper databasehelper;
    ArrayList<String> range = new ArrayList<>();
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backend_button = (Button) findViewById(R.id.back_end);
        databasehelper=new Databasehelper(this);
        listView=(ListView)findViewById(R.id.list_view);
populateListView();
        backend_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,backend.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void populateListView() {
        //get the data and append to a list
        Cursor data = databasehelper.getData();
        range.clear();
        while(data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            range.add(data.getPosition() + 1 + " | name: "+data.getString(1) +" | price: "+data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, range);
        listView.setAdapter(adapter);
    }
}
