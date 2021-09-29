package com.example.jccl_network_project.detail_pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
;
import com.example.jccl_network_project.R;

import java.util.LinkedList;


public class WordCategoryAdapter  extends RecyclerView.Adapter<WordCategoryAdapter.Word_viewholder>  {


    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordCategoryAdapter( Context context ,LinkedList<String> mWordList) {
        this.mWordList = mWordList;
        mInflater = LayoutInflater.from(context);
    }


    class Word_viewholder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;
        final WordCategoryAdapter mAdater;

        public Word_viewholder(@NonNull View itemView, WordCategoryAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.item_category);
            this.mAdater = adapter;
        }

    }
    @NonNull
    @Override
    public WordCategoryAdapter.Word_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_category,
                parent, false);
        return new Word_viewholder(mItemView, this);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    @Override
    public void onBindViewHolder(@NonNull WordCategoryAdapter.Word_viewholder holder, int position) {

        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }


}