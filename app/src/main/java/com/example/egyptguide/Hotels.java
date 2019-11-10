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
public class Hotels extends Fragment implements HotelAdapter.onClickListItem {

    public static ArrayList<HotelClass> hotels;

    @Override
    public void onClickListItemHandler(int pos) {
        getActivity().startActivity(
                new Intent(getContext(), Details_Activity.class)
                        .putExtra(getString(R.string.current_entity), hotels.get(pos))
                        .putExtra(getString(R.string.ENTITY_TYPE), MainActivity.HOTEL)
                        .putExtra(getString(R.string.ENTITY_POS), pos)
        );
        Toast.makeText(getContext(), getString(R.string.details), Toast.LENGTH_SHORT).show();
    }

    public Hotels() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        HotelAdapter hotelAdapter;
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        if (hotels == null) {
            hotels = new ArrayList<>();
            loadData();
        }
        recyclerView = rootView.findViewById(R.id.rv_hotels);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        hotelAdapter = new HotelAdapter(this, getContext(), hotels);
        recyclerView.setAdapter(hotelAdapter);
        return rootView;
    }

    private void loadData() {
        //String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.t21, R.drawable.t23},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.t23, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));

        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.t21, R.drawable.t23},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.t23, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.t21, R.drawable.t23},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));

    }

}
