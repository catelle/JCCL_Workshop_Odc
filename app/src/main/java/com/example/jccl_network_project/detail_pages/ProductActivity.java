package com.example.jccl_network_project.detail_pages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.detail_pages.WordCategoryAdapter;

import java.util.LinkedList;


public class ProductActivity extends AppCompatActivity{

    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mWordList.addLast("Tous");
        mWordList.addLast("Cours");
        mWordList.addLast("Exercices");
        mWordList.addLast("Corrigés");

        RecyclerView recyclerViewWord = findViewById(R.id.recyclerview_word);
        WordCategoryAdapter wordAdapter = new WordCategoryAdapter(this, mWordList);
        recyclerViewWord.setAdapter(wordAdapter);
        recyclerViewWord.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

//        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
//        DocumentAdapter docAdapter = new DocumentAdapter(this, DocumentModel.getObjectList());
//        recyclerViewDoc.setAdapter(docAdapter);
//        RecyclerView.LayoutManager gridLayoutDoc = new GridLayoutManager(this , 2,
//                LinearLayoutManager.VERTICAL, false);
//        recyclerViewDoc.setLayoutManager(gridLayoutDoc);

        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
        DocumentAdapter docAdapter = new DocumentAdapter(this, DocumentModel.getObjectList());
        recyclerViewDoc.setAdapter(docAdapter);
        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this ,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewDoc.setLayoutManager(linearLayoutDoc);


//        RecyclerView recyclerViewProfil = findViewById(R.id.recyclerview_grid);
//        ProfilAdapter profilAdapter = new ProfilAdapter(this, ProfilModel.getObjectList());
//        recyclerViewProfil.setAdapter(profilAdapter);
//        RecyclerView.LayoutManager gridLayoutProfil = new GridLayoutManager(this ,
//                2, LinearLayoutManager.VERTICAL, false);
//        recyclerViewProfil.setLayoutManager(gridLayoutProfil);

//        RecyclerView recyclerViewProfil = findViewById(R.id.recyclerview_grid);
//        ProfilAdapter profilAdapter = new ProfilAdapter(this, ProfilModel.getObjectList());
//        recyclerViewProfil.setAdapter(profilAdapter);
//        RecyclerView.LayoutManager linearLayoutProfil = new LinearLayoutManager(this , LinearLayoutManager.VERTICAL, false);
//        recyclerViewProfil.setLayoutManager(linearLayoutProfil);

    }

}