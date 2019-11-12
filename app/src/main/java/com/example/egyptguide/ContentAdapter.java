package com.example.egyptguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private int[] entities;

    public ContentAdapter(Context context, int[] sights) {
        this.entities = sights;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivContent = itemView.findViewById(R.id.iv_content_image);
        }
    }

    @NonNull
    @Override
    public ContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(entities[position]);
        holder.ivContent.setImageResource(entities[position]);
    }

    @Override
    public int getItemCount() {
        return entities.length;
    }
}