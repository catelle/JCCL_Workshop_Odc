package com.example.jccl_network_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.EditActivity;
import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.viewholders.General_viewholder;

import java.util.List;

public class General_adapter extends RecyclerView.Adapter<General_viewholder> {

    private List<Object> list ;
    private OnViewHolderCallback activity ;
    private LayoutInflater mInflater;
    private int itemLayout;

    public General_adapter(Context context, List<Object> list, int itemLayout){

        this.list = list;
        this.activity = activity;
        this.mInflater = LayoutInflater.from(context);
        this.itemLayout = itemLayout;
        this.list = list;
    }

    @NonNull
    @Override
    public General_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(itemLayout ,parent , false);
        return new General_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull General_viewholder holder, int position) {
        String edit = ((EditActivity.Formation) this.list.get(position)).getIntitule();
        holder.getEditFormation().setText(edit);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
