package com.example.egyptguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager=findViewById(R.id.container);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this,5);
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout= findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
