package com.example.jccl_network_project.detail_pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jccl_network_project.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumActivity extends AppCompatActivity {

    private final LinkedList<ReponseModel> mListReponse = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        mListReponse.addLast(new ReponseModel(R.mipmap.ic_profil_tech, "Junior Lagazette",
                "28.09.2021", "On parle souvent de design responsive : il s\\'agit d\\'une technique de\n" +
                "        design où l\\'apparence d\\'une page ou d\\'une application dépend de l\\'appareil sur lequel on\n" +
                "        les consulte. On dépendra souvent de la largeur en pixels de la fenêtre de navigateur.", R.mipmap.ic_livre_mathpc));
        mListReponse.addLast(new ReponseModel(R.mipmap.ic_profil_tech, "Junior Lagazette",
                "28.09.2021", "On parle souvent de design responsive : il s\\'agit d\\'une technique de\n" +
                "        design où l\\'apparence d\\'une page ou d\\'une application dépend de l\\'appareil sur lequel on\n" +
                "        les consulte. On dépendra souvent de la largeur en pixels de la fenêtre de navigateur.", R.mipmap.ic_livre_mathpc));
        mListReponse.addLast(new ReponseModel(R.mipmap.ic_profil_tech, "Junior Lagazette",
                "28.09.2021", "On parle souvent de design responsive : il s\\'agit d\\'une technique de\n" +
                "        design où l\\'apparence d\\'une page ou d\\'une application dépend de l\\'appareil sur lequel on\n" +
                "        les consulte. On dépendra souvent de la largeur en pixels de la fenêtre de navigateur.", R.mipmap.ic_livre_mathpc));
        mListReponse.addLast(new ReponseModel(R.mipmap.ic_profil_tech, "Junior Lagazette",
                "28.09.2021", "On parle souvent de design responsive : il s\\'agit d\\'une technique de\n" +
                "        design où l\\'apparence d\\'une page ou d\\'une application dépend de l\\'appareil sur lequel on\n" +
                "        les consulte. On dépendra souvent de la largeur en pixels de la fenêtre de navigateur.", R.mipmap.ic_livre_mathpc));

        RecyclerView recyclerViewReponse = findViewById(R.id.reponses);
        ReponseAdapter reponseAdapter = new ReponseAdapter(this, mListReponse);
        recyclerViewReponse.setAdapter(reponseAdapter);
        recyclerViewReponse.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
    }
}