package com.example.jccl_network_project.custom_interface;

import android.view.View;

import androidx.annotation.Nullable;

public interface OnViewHolderCallback {

    void setItemInformation(Object object ,@Nullable String request_code);
    void onItemClick(int position ,@Nullable String request_code);
    void bindItemView(View view ,@Nullable String request_code);

}
