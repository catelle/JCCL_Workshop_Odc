package com.example.jccl_network_project.viewholders;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.models.Commentaire;

public class CommentaireViewHolder extends RecyclerView.ViewHolder {

    // Declaration des views
    private TextView commentText ;
    private TextView commentDate;
    private ImageView commentPoster;
    private Context context;

    public CommentaireViewHolder(@NonNull View view , Context context) {
        super(view);
        this.context = context;
        commentText = view.findViewById(R.id.text_comment);
        commentDate = view.findViewById(R.id.text_comment_date);
        commentPoster = view.findViewById(R.id.image_comment_poster);
    }

    public void setCommentInformation(Commentaire comment){
        // bind de la photo du comnmentaire
        int resId = this.context.getResources().getIdentifier(comment.getCommenteurPhoto() , "mipmap", this.context.getPackageName());
        commentPoster.setImageResource(resId);
        // bind du texte de commentaire
        commentText.setText(comment.getTexte());
        Log.d("***view", comment.getTexte() + "");
        // bind du texte de la date
        commentDate.setText(comment.getDate_creation());
    }


}
