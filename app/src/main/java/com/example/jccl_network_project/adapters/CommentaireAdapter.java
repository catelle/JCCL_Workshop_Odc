package com.example.jccl_network_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.models.Commentaire;
import com.example.jccl_network_project.viewholders.CommentaireViewHolder;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentaireAdapter extends RecyclerView.Adapter<CommentaireViewHolder> {

    private List<Commentaire> list;
    private Context context;


    public CommentaireAdapter( Context context ,List<Commentaire> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentaireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.comment_item, parent , false);
        return new CommentaireViewHolder(view , context);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentaireViewHolder holder, int position) {
      holder.setCommentInformation(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
