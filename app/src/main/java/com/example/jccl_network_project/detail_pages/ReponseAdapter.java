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


public class ReponseAdapter extends RecyclerView.Adapter<ReponseAdapter.ReponseviewHolder>{
    
    private List<ReponseModel> mListReponse;
    private LayoutInflater mInflater;

    public ReponseAdapter(Context context, List<ReponseModel> mListReponse) {
        this.mListReponse = mListReponse;
        mInflater = LayoutInflater.from(context);
    }

    public class ReponseviewHolder extends RecyclerView.ViewHolder{
        
        private ImageView mImg_posted;
        private TextView mText_reponse;
        private TextView mDate_posted;
        private ImageView mImg_reponse;
        private TextView mName_posted;
        private int position;


        public ReponseviewHolder(@NonNull View itemView) {
            super(itemView);
            mImg_posted = itemView.findViewById(R.id.img_posted);
            mText_reponse = itemView.findViewById(R.id.text_reponse);
            mDate_posted = itemView.findViewById(R.id.date_posted);
            mName_posted = itemView.findViewById(R.id.name_posted);
            mImg_reponse = itemView.findViewById(R.id.img_reponse);
        }

        public  void setData(ReponseModel  currentObjet, int position){
            this.mImg_reponse.setImageResource(currentObjet.getImg_reponse());
            this.mName_posted.setText(currentObjet.getName_posted());
            this.mDate_posted.setText(currentObjet.getDate_post());
            this.mText_reponse.setText(currentObjet.getText_reponse());
            this.mImg_posted.setImageResource(currentObjet.getImg_posted());
            this.position = position;
        }
    }
    @NonNull
    @Override
    public ReponseAdapter.ReponseviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_reponse, parent, false);
        ReponseAdapter.ReponseviewHolder holder = new ReponseAdapter.ReponseviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReponseAdapter.ReponseviewHolder holder, int position) {
        ReponseModel current = mListReponse.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return mListReponse.size();
    }
}
