package com.example.jccl_network_project.detail_pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.models.Fil_discussion;

import org.w3c.dom.Text;

import java.util.List;

public class FilDiscussionAdapter extends RecyclerView.Adapter<FilDiscussionAdapter.FilDiscussionviewHolder> {

    private List<Fil_discussion> mListFile;
    private LayoutInflater mlayoutInflater;

    public FilDiscussionAdapter(@NonNull Context context, List<Fil_discussion> mListFile) {
        this.mListFile = mListFile;
        mlayoutInflater = LayoutInflater.from(context);
    }

    class FilDiscussionviewHolder extends RecyclerView.ViewHolder{

        private TextView mSujet;
        private TextView mProbleme;
        private ImageView mImage_posted;
        private TextView mDate_posted;
        private TextView mName_posted;
        private TextView mNb_commented;
        private FilDiscussionAdapter mAdapter;
        private int position;

        public FilDiscussionviewHolder(@NonNull View itemView, FilDiscussionAdapter adapter) {
            super(itemView);
            mSujet =itemView.findViewById(R.id.sujet);
            mProbleme = itemView.findViewById(R.id.probleme);
            mDate_posted = itemView.findViewById(R.id.date_posted);
            mImage_posted= itemView.findViewById(R.id.img_posted);
            mNb_commented = itemView.findViewById(R.id.nb_comment);
            mName_posted = itemView.findViewById(R.id.name_profil);
            this.mAdapter = adapter;
        }

        public void setData(Fil_discussion current,int position){
            this.mSujet.setText(current.getTitre());
            this.mProbleme.setText(current.getProbleme());
            this.mName_posted.setText(current.getName_posted());
            this.mImage_posted.setImageResource(current.getImg_poster());
            this.mNb_commented.setText(current.getNb_commented());
            this.mDate_posted.setText(current.getDate_creation());
            this.position = position;
        }


    }

    @NonNull
    @Override
    public FilDiscussionviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mlayoutInflater.inflate(R.layout.index_fil_discussion, parent, false);
        return new FilDiscussionviewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FilDiscussionviewHolder holder, int position) {

        Fil_discussion mCurrent = mListFile.get(position);
        holder.setData(mCurrent, position);
    }

    @Override
    public int getItemCount() {
        return mListFile.size();
    }



}
