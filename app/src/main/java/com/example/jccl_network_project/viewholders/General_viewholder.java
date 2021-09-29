package com.example.jccl_network_project.viewholders;

import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;

import java.util.List;

public class General_viewholder extends RecyclerView.ViewHolder {

    public EditText editFormation ;

    public General_viewholder(@NonNull View itemView) {
        super(itemView);
        editFormation = itemView.findViewById(R.id.edit_formation);
    }
    public EditText getEditFormation(){ return editFormation; };
}


