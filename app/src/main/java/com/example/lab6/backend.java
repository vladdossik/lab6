package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class backend extends AppCompatActivity {
Button storefrontbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backend);
        storefrontbutton=(Button)findViewById(R.id.store_front);
        storefrontbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(backend.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
