package com.example.jccl_network_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.viewholders.NoteCommentViewHolder;

import java.util.List;

public class NoteCommentAdapter extends RecyclerView.Adapter<NoteCommentViewHolder> {

    private Context context;
    private List<Float> list;

    public NoteCommentAdapter(Context context, List<Float> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoteCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.star_item , parent , false);
        return new NoteCommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteCommentViewHolder holder, int position) {
         NoteCommentViewHolder.setPopupNoteInformation(list);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
