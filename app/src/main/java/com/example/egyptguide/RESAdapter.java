package com.example.egyptguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RESAdapter extends RecyclerView.Adapter<RESAdapter.ViewHolder> {
    private ArrayList<RestaurantClass> Restaurants;
    private onClickListItem clickListItem;

    public interface onClickListItem {
        void onClickListItemHandler(int pos);
    }

    public RESAdapter(onClickListItem context, ArrayList<RestaurantClass> contents) {
        this.Restaurants = contents;
        clickListItem = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivHotel;
        private TextView tvLocation;
        private TextView tvName;
        private TextView tvFees;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHotel = itemView.findViewById(R.id.iv_entity_icon);
            tvName = itemView.findViewById(R.id.tv_entity_name);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvFees = itemView.findViewById(R.id.tv_fees);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListItem.onClickListItemHandler(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RESAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RESAdapter.ViewHolder holder, int position) {
        RestaurantClass curr = Restaurants.get(position);
        holder.itemView.setTag(curr);
        holder.tvName.setText(curr.getmName());
        holder.tvLocation.setText(curr.getmLocation());
        holder.tvFees.setVisibility(View.GONE);
        holder.ivHotel.setImageResource(curr.getmImageResources()[0]);
    }

    @Override
    public int getItemCount() {
        return Restaurants.size();
    }
}
