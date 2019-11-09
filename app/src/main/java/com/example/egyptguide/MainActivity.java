package com.example.egyptguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public final static int UNIVERSITY = 0;
    public final static int ENTERTAINMENT = 1;
    public final static int BANK = 2;
    public final static int HOTEL = 3;
    public final static int RESTAURANT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.container);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this, 5);
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
