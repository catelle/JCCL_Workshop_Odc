package com.example.jccl_network_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.jccl_network_project.MainActivity.TAGlocalisation;
import static com.example.jccl_network_project.MainActivity.TAGprofession;
import static com.example.jccl_network_project.MainActivity.TAGprofile_image;
import static com.example.jccl_network_project.MainActivity.TAGusername;

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

        mauth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        //a supprimé une fois l'association réelle faite

       save=findViewById(R.id.Editer);

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email="catelleningha@gmail.com";
               //recuperation des données tests sur les valeurs
               DocumentReference ref=firestore.collection("Utilisateur").document(mauth.getUid());
               Map  < String,Object > edited=new HashMap<>();
               edited.put("email",email);
               edited.put("profession",profession);


           }
               });




    }

    }

