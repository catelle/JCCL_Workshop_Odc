package com.example.jccl_network_project.custom_interface;

import android.view.View;

public interface OnViewHolderCallback {

    void setItemInformation(Object object);
    void OnItemClick(int position, View itemView);
    void bindItemView(View view);

}
