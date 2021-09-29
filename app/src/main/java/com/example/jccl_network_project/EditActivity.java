package com.example.jccl_network_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jccl_network_project.adapters.General_adapter;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.UpdateDocumentRequest;

import java.util.ArrayList;

import java.util.Date;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import static com.example.jccl_network_project.Profil_fragment.TAGlocalisation;
import static com.example.jccl_network_project.Profil_fragment.TAGnom;
import static com.example.jccl_network_project.Profil_fragment.TAGprofession;

public class EditActivity extends AppCompatActivity {

    List<Object> list;
    General_adapter adapter;
    RecyclerView recycler;


    FirebaseAuth mAuth;
    FirebaseFirestore db;

    EditText nomET,professionET,descriptionET,emailET,villeET;
    Button validation;
    String localisation, profession;
    private View add_formation_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        recycler = findViewById(R.id.recycler_formation);

        mAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();

        list = new ArrayList<>();
        list.add(new Formation("bonjour"));
        list.add(new Formation("bonsoir"));
        list.add(new Formation("salut"));
        list.add(new Formation("yo"));
        list.add(new Formation("Hola"));
        adapter = new General_adapter(this, list, R.layout.formation_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this ,RecyclerView.VERTICAL , false);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

        Date date_1 =  new Date("01/01/2001");
        Log.d("***date" , date_1.getTime()+"" );
    }


    public class  Formation{
        private String intitule;

        public Formation(String intitule) {
            this.intitule = intitule;
        }

        public String getIntitule() {
            return intitule;
        }

        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }
    }
}