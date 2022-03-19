package com.example.jccl_network_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.viewholders.GeneralRecyclerViewHolder;

import java.util.List;

public class GeneralRecyclerAdapter extends RecyclerView.Adapter<GeneralRecyclerViewHolder> {

    private Context ctx ;
    private OnViewHolderCallback onviewHolderCallback ;
    private List<Object> list;
    private int itemLayout ;
    private View view ;
    private String request_code = null ;

    public GeneralRecyclerAdapter(Context ctx, OnViewHolderCallback onviewHolderCallback, List<Object> list, int itemLayout ,@Nullable String request_code) {
        this.ctx = ctx;
        this.onviewHolderCallback = onviewHolderCallback;
        this.list = list;
        this.itemLayout = itemLayout;
        this.request_code = request_code;
    }

    public GeneralRecyclerAdapter(Context ctx, OnViewHolderCallback onviewHolderCallback, List<Object> list, int itemLayout ) {
        this.ctx = ctx;
        this.onviewHolderCallback = onviewHolderCallback;
        this.list = list;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public GeneralRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(ctx).inflate(itemLayout , parent , false);
        return new GeneralRecyclerViewHolder(view , onviewHolderCallback , request_code);
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralRecyclerViewHolder holder, int position) {
        onviewHolderCallback.setItemInformation(list.get(position) , request_code );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
