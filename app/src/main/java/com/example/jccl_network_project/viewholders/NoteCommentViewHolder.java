package com.example.jccl_network_project.viewholders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;

import java.util.List;

public class NoteCommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView mStar;
    public NoteCommentViewHolder(@NonNull View view) {
        super(view);
        mStar = view.findViewById(R.id.image_star_item);
    }

    public static void setPopupNoteInformation(List<Float> list) {

    }

    @Override
    public void onClick(View view) {
       if (mStar.getDrawable().equals(R.drawable.ic_empty_star));
    }
}
