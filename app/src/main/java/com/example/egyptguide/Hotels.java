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

   private HotelAdapter hotelAdapter;
    public static ArrayList<HotelClass> hotels;

    @Override
    public void onClickListItemHandler(int pos) {
        getActivity().startActivity(
                new Intent(getContext(), Details_Activity.class)
                        .putExtra(getString(R.string.current_entity), hotels.get(pos))
                        .putExtra(getString(R.string.ENTITY_TYPE), MainActivity.HOTEL)
        );
        Toast.makeText(getContext(), getString(R.string.details), Toast.LENGTH_SHORT).show();
    }
    public Hotels() {
        // Required empty public constructor
    }

    private void loadData() {
        //String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources
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
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
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
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
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
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        hotels.add(new HotelClass(getContext().getString(R.string.star_hotel),
                getContext().getString(R.string.hotel_description),
                20,
                getContext().getString(R.string.location),
                new int[]{R.drawable.ic_location_city_black_24dp, R.drawable.ic_explore_black_24dp},
                getContext().getString(R.string.work_time, 9, 4),
                getContext().getString(R.string.phone_no1)));
        for (int i=0 ; i<hotels.size()/2;i++)
        {
            hotels.get(i).setmIsPreferred(true);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        hotels = new ArrayList<HotelClass>();
        loadData();

        recyclerView = rootView.findViewById(R.id.rv_hotels);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        hotelAdapter = new HotelAdapter(this, getContext(), hotels);
        recyclerView.setAdapter(hotelAdapter);
        return rootView;
    }

    public static void loadSSpecial(int type) {
        switch (type) {
            case MainActivity.STARRED:
                for (int i = 0; i < hotels.size(); i++) {
                    if (!hotels.get(i).ismIsPreferred()) {
                        hotels.remove(hotels.get(i));
                    }
                }
                break;
            case MainActivity.FAMOUS:
                for (int i = 0; i < hotels.size(); i++) {
                    if (!hotels.get(i).isFamous()) {
                        hotels.remove(hotels.get(i));
                    }
                }
                break;
        }
    }


}
