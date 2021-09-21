package com.example.jccl_network_project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import static com.example.jccl_network_project.MainActivity.TAGlocalisation;
import static com.example.jccl_network_project.MainActivity.TAGprofession;
import static com.example.jccl_network_project.MainActivity.TAGprofile_image;
import static com.example.jccl_network_project.MainActivity.TAGusername;

import com.example.jccl_network_project.adapters.General_adapter;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditActivity extends AppCompatActivity {

    EditText nomEditText,prenomEditText,emailEditText,mot_de_passeEditText;
    ImageView profile_imageView;

    String nom;
    String prenom;
    String email;
    String mot_de_passe;
    ImageView profile_image;
    String localisation;
    String profession;
    Button save;

    FirebaseAuth mauth;
    FirebaseFirestore firestore;

    List<Object> list;
    General_adapter adapter;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // on doit recupere les donnée du profil qui existe deja et les placer comme hint

       Intent data=getIntent();
       nom=data.getStringExtra(TAGusername);
       localisation=data.getStringExtra(TAGlocalisation);
       profession=data.getStringExtra(TAGprofession);



       // creer les champs qui peuvent etre ajouter




        //Assoicié le bouton save au composant de la vue




        // recuperer les nouvelles données au clic sur le bouton enregistre et les modifier dans la BD

        mauth= FirebaseAuth.getInstance();
        firestore= FirebaseFirestore.getInstance();

        //a supprimé une fois l'association réelle faite

       save=findViewById(R.id.Editer);

        recycler = findViewById(R.id.recycler_formation);

        list = new ArrayList<>();
        list.add(new Formation("bonjour"));
        list.add(new Formation("bonsoir"));
        list.add(new Formation("salut"));
        list.add(new Formation("yo"));
        list.add(new Formation("Hola"));
        adapter = new General_adapter(this, list ,R.layout.formation_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this ,RecyclerView.VERTICAL , false);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

        Date date_1 =  new Date("01/01/2001");
        Log.d("***date" , date_1.getTime()+"" );
       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email="catelleningha@gmail.com";
               //recuperation des données tests sur les valeurs
               DocumentReference ref=firestore.collection("Utilisateur").document(mauth.getUid());
               Map< String,Object > edited=new HashMap<>();
               edited.put("email",email);
               edited.put("profession",profession);


           }
               });




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



