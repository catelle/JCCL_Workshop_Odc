package com.example.jccl_network_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.models.Utilisateur;
import com.example.jccl_network_project.utils.FirebaseUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText nomEditText,emailEditText;
    String nom, email, statut_utilisateur;
    Boolean validation;

    TextView continue_button;
    public static final String TAGuserid="uid";
    public static final String TAGuid ="uid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        ActionBar act;
        act=getSupportActionBar();
        ColorDrawable cd=new ColorDrawable(Color.parseColor("#993300"));
        act.setBackgroundDrawable(cd);
        Spinner spinner = findViewById(R.id.spinner_country_code);
        nomEditText=findViewById(R.id.phone_number);
        emailEditText=findViewById(R.id.email);
        continue_button=findViewById(R.id.continue_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=nomEditText.getText().toString();
                String email=emailEditText.getText().toString();
                if (!(email.isEmpty())&&(!(email.contains("@"))||!(email.contains("."))||!(email.contains("com")))){
                    emailEditText.setError("Entrez une email de la forme toto@gmail.com");

                }else{
                    Utilisateur user=new Utilisateur(FirebaseAuth.getInstance().getUid(),nom,statut_utilisateur,email,validation);
                    Utilisateur user =new Utilisateur(FirebaseAuth.getInstance().getCurrentUser().toString(),nom,statut_utilisateur,email,validation);
                    FirebaseUtils.addTask(user);
                    Toast.makeText(InscriptionActivity.this,"Vous etes desormais utilisateur",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(InscriptionActivity.this,LoginActivity.class);
                    intent.putExtra(TAGuserid,FirebaseAuth.getInstance().getUid());
                    intent.putExtra(TAGuid,FirebaseAuth.getInstance().getCurrentUser());
                    startActivity(intent);
                    finish();
                }
            }
        });
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        statut_utilisateur=adapterView.getSelectedItem().toString();
        if(statut_utilisateur=="Etudiant"||statut_utilisateur=="Eleve"){
            validation=true;
        }else{
            validation=false;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}