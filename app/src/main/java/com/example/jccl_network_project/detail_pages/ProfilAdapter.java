package com.example.jccl_network_project.detail_pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;

import java.util.List;

public class ProfilAdapter extends RecyclerView.Adapter<ProfilAdapter.ProfilviewHolder>{

    private List<ProfilModel> objectList;
    private LayoutInflater inflater;

    public ProfilAdapter(Context context, List<ProfilModel> objectList) {
        this.objectList = objectList;
        inflater = LayoutInflater.from(context);
    }

    class ProfilviewHolder extends RecyclerView.ViewHolder{

        private final ImageView img_profil;
        private final TextView name;
        private final TextView skill;
        private  int position;
        private ProfilModel currentObject;

        public ProfilviewHolder(@NonNull View itemView) {
            super(itemView);

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
    }


    @NonNull
    @Override
    public ProfilviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.teacher_item,
                parent, false);
        ProfilAdapter.ProfilviewHolder holder = new ProfilAdapter.ProfilviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilviewHolder holder, int position) {
        ProfilModel current = objectList.get(position);
        holder.setData(current, position);

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }



}
