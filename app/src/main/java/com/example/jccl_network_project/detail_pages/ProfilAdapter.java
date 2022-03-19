package com.example.jccl_network_project.detail_pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.custom_interface.OnItemClickListener;
import com.example.jccl_network_project.viewholders.ProfilviewHolder;

import java.util.List;

public class ProfilAdapter extends RecyclerView.Adapter<ProfilviewHolder>{

    private List<Object> objectList;
    private LayoutInflater inflater;
    private  OnItemClickListener onItemClickListener;

    public ProfilAdapter(Context context, List<Object> objectList ,  OnItemClickListener onItemClickListener) {
        this.objectList = objectList;
        this.onItemClickListener = onItemClickListener ;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ProfilviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.teacher_item,
                parent, false);
        return new ProfilviewHolder(view , onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilviewHolder holder, int position) {
        ProfilModel current = (ProfilModel) objectList.get(position);
        holder.setData(current, position);

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }



}
