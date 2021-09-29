package com.example.jccl_network_project.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.custom_interface.OnItemClickListener;
import com.example.jccl_network_project.detail_pages.ProfilModel;

public class ProfilviewHolder extends RecyclerView.ViewHolder implements OnItemClickListener {

    private final ImageView img_profil;
    private final TextView name;
    private final TextView skill;
    private int position;
    private ProfilModel currentObject;
    private OnItemClickListener onItemClickListener;

    public ProfilviewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);

        this.onItemClickListener = onItemClickListener;
        img_profil = itemView.findViewById(R.id.img_profil);
        name = itemView.findViewById(R.id.name);
        skill = itemView.findViewById(R.id.skill);

    }

    public void setData(ProfilModel currentObject, int position) {

        this.img_profil.setImageResource(currentObject.getImg_profil());
        this.name.setText(currentObject.getName());
        this.skill.setText(currentObject.getSkill());
        this.position = position;
        this.currentObject = currentObject;
    }

    @Override
    public void onItemClick(int position) {
        onItemClickListener.onItemClick(getAdapterPosition());
    }
}
