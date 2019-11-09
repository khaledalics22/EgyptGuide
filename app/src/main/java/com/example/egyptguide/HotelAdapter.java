package com.example.egyptguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{
    private ArrayList<HotelClass> Hotels;
    private onClickListItem clickListItem;
    public  interface onClickListItem{
        void onClickListItemHandler(int pos);
    }

    public HotelAdapter(onClickListItem context, ArrayList<HotelClass> contents) {
            this.Hotels = contents;
            clickListItem=context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivEntity;
        private TextView  tvLocation;
        private TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivEntity =itemView.findViewById(R.id.iv_entity_icon);
            tvName=itemView.findViewById(R.id.tv_entity_name);
            tvLocation=itemView.findViewById(R.id.tv_location);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListItem.onClickListItemHandler(getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, int position) {
        HotelClass currHotel= Hotels.get(position);
        holder.itemView.setTag(currHotel);
        holder.tvName.setText(currHotel.getmName());
        holder.tvLocation.setText(currHotel.getmLocation());
        holder.ivEntity.setImageResource(currHotel.getmImageResources()[0]);
    }
    @Override
    public int getItemCount() {
        return Hotels.size();
    }
}
