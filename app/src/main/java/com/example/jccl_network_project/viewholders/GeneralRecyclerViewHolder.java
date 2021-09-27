package com.example.jccl_network_project.viewholders;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;

public class GeneralRecyclerViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnViewHolderCallback onviewHolderCallback ;
    private final View itemView ;

    public GeneralRecyclerViewHolder(@NonNull View itemView, OnViewHolderCallback onviewHolderCallback) {
        super(itemView);
        this.onviewHolderCallback = onviewHolderCallback ;
        this.itemView = itemView;
        onviewHolderCallback.bindItemView(itemView);
    }

    @Override
    public void onClick(View view) {
       onviewHolderCallback.OnItemClick(getAdapterPosition() , itemView);
    }
}
