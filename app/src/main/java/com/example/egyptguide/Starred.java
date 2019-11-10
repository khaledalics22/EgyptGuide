package com.example.egyptguide;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Starred extends AppCompatActivity implements StarredAdapter.onClickListItem {
    @Override
    public void onClickListItemHandler(int pos) {

    }

    private ArrayList<Entity> starredEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.starred);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        loadStarred();
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        StarredAdapter recyclerViewAdapter;
        recyclerView = findViewById(R.id.rv_starred_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new StarredAdapter(this, starredEntities);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadStarred() {
        starredEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            starredEntities.add(new Entity(getString(R.string.entity),
                    getString(R.string.details),
                    getString(R.string.location),
                    new int[]{R.drawable.drawererimage},
                    getResources().getString(R.string.work_time, 6, 3).toString(),
                    getString(R.string.phone_number)));
            starredEntities.get(i).setmIsPreferred(true);
        }
    }
}
