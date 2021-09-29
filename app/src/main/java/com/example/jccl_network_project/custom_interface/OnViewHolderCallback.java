package com.example.jccl_network_project.custom_interface;

import android.view.View;

import java.util.List;

public interface OnViewHolderCallback {

    void setFavorisViewInformation(int position);
    List<View> getViews();
    void OnItemClick(int position);


}
