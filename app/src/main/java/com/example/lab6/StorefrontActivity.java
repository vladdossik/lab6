package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.lab6.DatabaseHelper;
import com.example.lab6.PageFragment;
import com.example.lab6.R;
import com.example.lab6.ViewPagerAdapter;

public class StorefrontActivity extends AppCompatActivity implements PageFragment.OnFragmentDataListener {

    public static ViewPagerAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storefront);

        viewPager = findViewById(R.id.pager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), new DatabaseHelper(getApplicationContext()).getArrayList());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentDataListener() {
        adapter.notifyDataSetChanged();
    }
}
