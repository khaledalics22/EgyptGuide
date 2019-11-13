package com.example.egyptguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

/**
 * Author: Khaled Ali
 * date : 13/11/2019
 * version : 1
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public final static int UNIVERSITY = 0;
    public final static int ENTERTAINMENT = 1;
    public final static int BANK = 2;
    public final static int HOTEL = 3;
    public final static int RESTAURANT = 4;
    private ViewPager viewPager;
    private data mData;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView;
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        if (mData == null) {

            //load data from database
            mData = new data(this);
            mData.loadData();
        }
        viewPager = findViewById(R.id.container);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),
                this, 5);
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        drawer = findViewById(R.id.drawer_layout);
        new AppBarConfiguration.Builder(R.id.starred, R.id.general,
                R.id.feedback)
                .setDrawerLayout(drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.general);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.starred:

                //delete not starred and notify adapter
                mData.loadStarred();
                viewPager.getAdapter().notifyDataSetChanged();
                drawer.closeDrawer(GravityCompat.START);
                return true;
            case R.id.general:

                // reload all data and notify adapter
                mData.loadData();
                viewPager.getAdapter().notifyDataSetChanged();
                drawer.closeDrawer(GravityCompat.START);
                return true;
            case R.id.feedback:

                // send email to application makers
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email)});
                email.putExtra(Intent.EXTRA_SUBJECT, R.string.feedback);
                email.putExtra(Intent.EXTRA_TEXT, R.string.have_problem);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
