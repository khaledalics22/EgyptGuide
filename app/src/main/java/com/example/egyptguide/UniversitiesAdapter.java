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

public class UniversitiesAdapter extends RecyclerView.Adapter<UniversitiesAdapter.ViewHolder>{
    private ArrayList<UniversitiesClass> universities;
    private onClickListItem clickListItem;
    public  interface onClickListItem{
        void onClickListItemHandler(int pos);
    }

    public UniversitiesAdapter(onClickListItem context, ArrayList<UniversitiesClass> contents) {
            this.universities = contents;

            clickListItem=(onClickListItem)context;

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
    public UniversitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversitiesAdapter.ViewHolder holder, int position) {
        UniversitiesClass curr= universities.get(position);
        holder.itemView.setTag(curr);
        holder.tvName.setText(curr.getmName());
        holder.tvLocation.setText(curr.getmLocation());
        holder.ivEntity.setImageResource(curr.getmImageResources()[0]);
    }
    @Override
    public int getItemCount() {
        return universities.size();
    }
}
