package com.example.jccl_network_project.viewholders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.models.ModelFavorisItem;

import org.w3c.dom.Text;

public class FavorisViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageBook;
    private TextView  title , categorie , namePoster;

    public FavorisViewHolder(@NonNull View itemView) {
        super(itemView);

        imageBook = itemView.findViewById(R.id.image_book);
        title = itemView.findViewById(R.id.text_title);
        categorie = itemView.findViewById(R.id.text_categorie);
        namePoster = itemView.findViewById(R.id.text_poster_name);

        Log.d("***tag2" ,  "Construis" );

    }

    public ImageView getImageBook() {
        return imageBook;
    }

    public void setImageBook(ImageView imageBook) {
        this.imageBook = imageBook;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getCategorie() {
        return categorie;
    }

    public void setCategorie(TextView categorie) {
        this.categorie = categorie;
    }

    public TextView getNamePoster() {
        return namePoster;
    }

    public void setNamePoster(TextView namePoster) {
        this.namePoster = namePoster;
    }

    public void setItemInformation(ModelFavorisItem item){
        getTitle().setText(item.getTitle());
        getCategorie().setText(item.getCategorie());
        getNamePoster().setText(item.getPosterName());

        Log.d("***tag" , item.getPosterName() + "" );
    }

}


