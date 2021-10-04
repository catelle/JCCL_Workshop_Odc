package com.example.jccl_network_project.viewholders;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;

public class GeneralRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final OnViewHolderCallback onviewHolderCallback;
    private final View itemView;
    private String request_code;

    public GeneralRecyclerViewHolder(@NonNull View itemView, OnViewHolderCallback onviewHolderCallback, @Nullable String request_code) {
        super(itemView);
        this.onviewHolderCallback = onviewHolderCallback;
        this.itemView = itemView;
        this.request_code = request_code;
        itemView.setOnClickListener(v -> onviewHolderCallback.onItemClick(getAdapterPosition(), request_code));
        onviewHolderCallback.bindItemView(itemView, request_code);

    }

    public OnViewHolderCallback getOnviewHolderCallback() {
        return onviewHolderCallback;
    }
}
