package com.example.jccl_network_project.detail_pages;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
;
import com.example.jccl_network_project.R;
import com.example.jccl_network_project.custom_interface.OnItemClickListener;
import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.viewholders.General_viewholder;

import java.util.LinkedList;
import java.util.List;


public class WordCategoryAdapter  extends RecyclerView.Adapter<WordCategoryAdapter.Word_viewholder>  {


    private  List<String> mCategorie;
    private LayoutInflater mInflater;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public WordCategoryAdapter(Context context , List<String> mCategorie , OnItemClickListener onItemClickListener) {
        this.mCategorie = mCategorie;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public WordCategoryAdapter.Word_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_category, parent, false);
        return new Word_viewholder(mItemView, onItemClickListener , context);
    }

    @Override
    public int getItemCount() {
        return mCategorie.size();
    }
    @Override
    public void onBindViewHolder(@NonNull WordCategoryAdapter.Word_viewholder holder, int position) {
        String mCurrent = mCategorie.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    public class Word_viewholder extends RecyclerView.ViewHolder  {

        private final TextView wordItemView;
        private final OnItemClickListener onItemClickListener;
        private Context context;

        public Word_viewholder(@NonNull View itemView, OnItemClickListener onItemClickListener, Context context) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.item_category);
            this.onItemClickListener = onItemClickListener;
            this.context = context;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }


    }

}