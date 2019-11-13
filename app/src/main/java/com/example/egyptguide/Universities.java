package com.example.egyptguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Universities extends Fragment implements UniversitiesAdapter.onClickListItem {
    public Universities() {// Required empty public constructor
    }

    @Override
    public void onClickListItemHandler(int pos) {

        // start detail activity and send position and type of Entity in Intent
        getContext().startActivity(
                new Intent(getContext(), Details_Activity.class)
                        .putExtra(getString(R.string.ENTITY_TYPE), MainActivity.UNIVERSITY)
                        .putExtra(getString(R.string.ENTITY_POS), pos));
        Toast.makeText(getContext(), getString(R.string.details), Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        UniversitiesAdapter recyclerViewAdapter;
        recyclerView = rootView.findViewById(R.id.rv_hotels);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new UniversitiesAdapter(this, getContext(), data.univerisities);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }
}
