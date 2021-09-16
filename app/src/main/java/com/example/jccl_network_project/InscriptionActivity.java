package com.example.jccl_network_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.models.Utilisateur;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    EditText nomUtilisateurEditText,emailEditText;
    Spinner mspinner;
    TextView continuerTextClickable;
    Boolean validation;

    private String mstatus,emailText,nom_utilisateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        emailEditText=findViewById(R.id.emaileditText);
        nomUtilisateurEditText=findViewById(R.id.nomutilisateureditText);


        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        continuerTextClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailText=emailEditText.getText().toString();
                nom_utilisateur=nomUtilisateurEditText.getText().toString();
                if(!(emailText).contains("@")||!(emailText).contains(".")||!(emailText).contains("gmail")){
                    emailEditText.setError("vous devez entrer une email de la forme toto@gmail.com");
                }else if(nom_utilisateur.length()<2){
                    nomUtilisateurEditText.setError("Entrez un nom d'utilisateur valide");

                }else{

                Utilisateur newUser  = new Utilisateur(null,null,mstatus,"",nom_utilisateur,"","",0,emailText,validation,null,null,null,null);

                db.collection("Utilisateur")
                        .add(newUser)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(InscriptionActivity.this,"Inscription réussie",Toast.LENGTH_LONG).show();
                           //startActivity(new Intent(InscriptionActivity.this,LoginActivity.class));
                                finish();
                            }
                        })
                  .addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Toast.makeText(InscriptionActivity.this,"Inscription échoué",Toast.LENGTH_LONG).show();

                      }
                  })      ;

                }
            }
        });

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

      mstatus = adapterView.getSelectedItem().toString();
      if(mstatus=="Etudiant"){
          this.validation=true;
      }else{
          this.validation=false;
      }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addUser(Utilisateur utilisateur){

    }
}