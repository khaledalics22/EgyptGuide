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
public class Restaurants extends Fragment implements RESAdapter.onClickListItem {
    private data mData;

    @Override
    public void onClickListItemHandler(int pos) {
        getActivity().startActivity(
                new Intent(getContext(), Details_Activity.class)
                        .putExtra(getString(R.string.ENTITY_TYPE), MainActivity.RESTAURANT)
                        .putExtra(getString(R.string.ENTITY_POS), pos));
        Toast.makeText(getContext(), getString(R.string.details), Toast.LENGTH_SHORT).show();
    }

    public Restaurants() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        if (data.mRestaurants == null) {
            mData = new data(getContext());
            mData.loadRestaurantData();
        }
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        RESAdapter recyclerViewAdapter;
        recyclerView = rootView.findViewById(R.id.rv_hotels);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RESAdapter(this, data.mRestaurants);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }

}
