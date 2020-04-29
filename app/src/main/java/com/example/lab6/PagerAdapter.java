package com.example.lab6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PagerAdapter extends Fragment {
    String name;
    String price;
    String amount;
    Button buy_button;
    public PagerAdapter(String name,String price,String amount){
        Bundle arguments = new Bundle();
        this.name = name;
        this.price = price;
        this.amount=amount;
        arguments.putString("name", name);
        arguments.putString("price", price);
        arguments.putString("amount", amount);
        setArguments(arguments);
    }
}
