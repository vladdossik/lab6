package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_item extends AppCompatActivity {
EditText add_name,add_price,add_amount;
Button add,cancel;
Databasehelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        add_name=(EditText)findViewById(R.id.add_name);
        add_amount=(EditText)findViewById(R.id.add_amount);
        add_price=(EditText)findViewById(R.id.add_price);
        add=(Button)findViewById(R.id.add_button);
        cancel=(Button)findViewById(R.id.cancel);
        databasehelper=new Databasehelper(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add_name.getText().length()==0 || add_amount.getText().length()==0 || add_price.getText().length()==0) {
                    toastMessage("Поля не должны быть пустыми");
                }
                else {
                    String name=add_name.getText().toString();
                    int amount=Integer.parseInt(add_amount.getText().toString());
                    int price=Integer.parseInt(add_price.getText().toString());
                    databasehelper.Add(name,price,amount);
                   toastMessage("Товар добавлен");
                     add_name.setText("");
                    add_amount.setText("");
                    add_price.setText("");
                }
                toastMessage("Кнопка add нажата");
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Add_item.this,backend.class);
                startActivity(intent);
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}