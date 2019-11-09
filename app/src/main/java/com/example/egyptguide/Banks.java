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
public class Banks extends Fragment implements BankAdapter.onClickListItem{


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BankAdapter bankAdapter;
    private ArrayList<BankClass> Banks;
    public Banks() {
        // Required empty public constructor

    }
    @Override
    public void onClickListItemHandler(int pos) {
        Toast.makeText(getContext(), getString(R.string.details),Toast.LENGTH_SHORT).show();

    }
    private void loadData()
    {
        //String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources
        Banks.add(new BankClass(getContext().getString(R.string.bank_masr),
            getContext().getString(R.string.bank_masr_desc),
            getContext().getString(R.string.location),
            new int[]{R.drawable.ic_location_city_black_24dp,R.drawable.ic_explore_black_24dp} ));
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_hotels, container, false);

        Banks =new ArrayList<BankClass>();
        loadData();

        recyclerView= rootView.findViewById(R.id.rv_hotels);
        layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        bankAdapter = new BankAdapter(this, Banks);
        recyclerView.setAdapter(bankAdapter);
        return rootView;
    }
}
