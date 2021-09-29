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
import com.example.jccl_network_project.models.Fil_discussion;

import java.util.LinkedList;


public class ProductActivity extends AppCompatActivity{

    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<Fil_discussion> mForumList = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mWordList.addLast("Tous");
        mWordList.addLast("Cours");
        mWordList.addLast("Exercices");
        mWordList.addLast("Corrigés");

//        mWordList.addLast("Tous");
//        mWordList.addLast("Resolu");
//        mWordList.addLast("Non Resolu");

        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));


        RecyclerView recyclerViewWord = findViewById(R.id.recyclerview_word);
        WordCategoryAdapter wordAdapter = new WordCategoryAdapter(this, mWordList);
        recyclerViewWord.setAdapter(wordAdapter);
        recyclerViewWord.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));


//        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
//        DocumentAdapter docAdapter = new DocumentAdapter(this, DocumentModel.getObjectList());
//        recyclerViewDoc.setAdapter(docAdapter);
//        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this ,
//                LinearLayoutManager.VERTICAL, false);
//        recyclerViewDoc.setLayoutManager(linearLayoutDoc);

        RecyclerView recyclerViewFilDiscussion = findViewById(R.id.recyclerview_grid);
        FilDiscussionAdapter fdAdapter = new FilDiscussionAdapter(this, mForumList);
        recyclerViewFilDiscussion.setAdapter(fdAdapter);
        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this ,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewFilDiscussion.setLayoutManager(linearLayoutDoc);




//        RecyclerView recyclerViewProfil = findViewById(R.id.recyclerview_grid);
//        ProfilAdapter profilAdapter = new ProfilAdapter(this, ProfilModel.getObjectList());
//        recyclerViewProfil.setAdapter(profilAdapter);
//        RecyclerView.LayoutManager linearLayoutProfil = new LinearLayoutManager(this , LinearLayoutManager.VERTICAL, false);
//        recyclerViewProfil.setLayoutManager(linearLayoutProfil);


    }

}