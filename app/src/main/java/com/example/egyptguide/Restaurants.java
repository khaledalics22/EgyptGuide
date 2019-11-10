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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Restaurants extends Fragment implements RESAdapter.onClickListItem {
    public static ArrayList<RestaurantClass> mRestaurants;

    @Override
    public void onClickListItemHandler(int pos) {
        getActivity().startActivity(
                new Intent(getContext(), Details_Activity.class)
                        .putExtra(getString(R.string.current_entity), mRestaurants.get(pos))
                        .putExtra(getString(R.string.ENTITY_TYPE), MainActivity.RESTAURANT)
                        .putExtra(getString(R.string.ENTITY_POS), pos));
        Toast.makeText(getContext(), getString(R.string.details), Toast.LENGTH_SHORT).show();
    }


    public Restaurants() {
        // Required empty public constructor
    }

    private void loadData() {
        //String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.restaurant),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.restaurant),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.restaurant),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.CarioUniversity),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.CarioUniversity),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.CarioUniversity),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.CarioUniversity),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(getContext().getString(R.string.CarioUniversity),
                getContext().getString(R.string.hotel_description),
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 10, 9),
                getContext().getResources().getString(R.string.phone_no1)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        RESAdapter recyclerViewAdapter;
        if (mRestaurants == null) {
            mRestaurants = new ArrayList<RestaurantClass>();
            loadData();
        }
        recyclerView = rootView.findViewById(R.id.rv_hotels);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RESAdapter(this, mRestaurants);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }

}
