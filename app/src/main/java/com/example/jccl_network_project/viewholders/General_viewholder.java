package com.example.jccl_network_project.viewholders;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;

import java.util.List;

public class General_viewholder extends RecyclerView.ViewHolder {

    public List<View> list;
    public EditText edit ;
    public General_viewholder(@NonNull View itemView, OnviewHolderCallback activity) {
        super(itemView);
        this.list = activity.getViews();
    }
}
