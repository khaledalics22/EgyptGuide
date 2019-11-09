package com.example.egyptguide;


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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Universities extends Fragment implements UniversitiesAdapter.onClickListItem{


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private UniversitiesAdapter recyclerViewAdapter;
    private ArrayList<UniversitiesClass> univerisities;
    public Universities() {
        // Required empty public constructor

    }
    @Override
    public void onClickListItemHandler(int pos) {
        Toast.makeText(getContext(), getString(R.string.details),Toast.LENGTH_SHORT).show();

    }
    private void loadData()
    {
        //String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
            getContext().getString(R.string.hotel_description),
            20,
            getContext().getString(R.string.location),
            new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
        univerisities.add(new UniversitiesClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_hotels, container, false);

        univerisities =new ArrayList<UniversitiesClass>();
        loadData();

        recyclerView= rootView.findViewById(R.id.rv_hotels);
        layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new UniversitiesAdapter(this, univerisities);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }
}
