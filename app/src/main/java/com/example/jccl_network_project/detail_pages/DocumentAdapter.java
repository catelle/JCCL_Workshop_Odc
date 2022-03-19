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
import com.example.jccl_network_project.models.Publication;

import java.util.ArrayList;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.Docviewholder>{

    private List<Object> objectList;
    private LayoutInflater inflater;

    public DocumentAdapter(Context context, List<Object> objectList) {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;

    }

    class Docviewholder extends RecyclerView.ViewHolder{

        private final ImageView img_doc;
        private final ImageView img_poster;
        private final TextView title_doc;
        private final TextView description_doc;
        private final TextView name_poster;
        private final TextView type_doc;
        private final TextView isFree;
        private final TextView note;
        private int position;
        private Publication currentObject;

        public Docviewholder(@NonNull View itemView) {
            super(itemView);
            img_doc = itemView.findViewById(R.id.img_doc) ;
            img_poster = itemView.findViewById(R.id.img_poster) ;
            title_doc = itemView.findViewById(R.id.title_doc);
            description_doc = itemView.findViewById(R.id.description_doc);
            name_poster = itemView.findViewById(R.id.name_poster);
            type_doc =  itemView.findViewById(R.id.type_doc);
            isFree = itemView.findViewById(R.id.isFree);
            note = itemView.findViewById(R.id.note);
        }

        public void setData(Publication currentObject, int position) {

//            this.img_doc.setImageResource(currentObject.getImg_profil_doc());
//            this.img_poster.setImageResource(currentObject.getImg_profil_poster());
            this.title_doc.setText(currentObject.getTitre());
            this.description_doc.setText(currentObject.getDescription());
            this.name_poster.setText(currentObject.getPoster_id());
            this.type_doc.setText(currentObject.getCategorie());
//            this.note.setText((ArrayList<Integer>) currentObject.getNote());
            this.isFree.setText("free");
            this.position = position;
            this.currentObject = currentObject;
        }
    }
    @NonNull
    @Override
    public DocumentAdapter.Docviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = inflater.inflate(R.layout.document_item,
                parent, false);
        Docviewholder holder = new Docviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentAdapter.Docviewholder holder, int position) {
        Publication current = (Publication) objectList.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }
}
