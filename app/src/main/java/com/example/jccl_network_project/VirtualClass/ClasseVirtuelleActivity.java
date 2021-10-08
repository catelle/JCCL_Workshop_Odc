package com.example.jccl_network_project.VirtualClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jccl_network_project.CreateFillDiscussion;
import com.example.jccl_network_project.MainActivity;
import com.example.jccl_network_project.R;

public class ClasseVirtuelleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classe_vituelle_blank);
    }

    public void clicregisteredtoCV(View view) {
        Intent intent=new Intent(ClasseVirtuelleActivity.this, classVirtuelleContent.class);
        startActivity(intent);
    }
}