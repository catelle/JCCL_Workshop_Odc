package com.example.jccl_network_project.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.models.ModelFavorisItem;
import com.example.jccl_network_project.tab_home_page.Favoris;
import com.example.jccl_network_project.viewholders.FavorisViewHolder;

import java.util.List;

public class FavorisAdapter extends RecyclerView.Adapter<FavorisViewHolder> {

    private List<ModelFavorisItem> list;
    private Context context ;

    public FavorisAdapter(Context context , List<ModelFavorisItem> list){
        this.context = context;
        this.list = list;
        Log.d("***tag3" ,  list.size()+"" );
    }
    @NonNull
    @Override
    public FavorisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favoris_item , parent , false);
        return new FavorisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavorisViewHolder holder, int position) {
//       holder.setItemInformation(list.get(position));
        holder.getTitle().setText(list.get(position).getTitle());
        holder.getCategorie().setText(list.get(position).getCategorie());
        holder.getNamePoster().setText(list.get(position).getPosterName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
