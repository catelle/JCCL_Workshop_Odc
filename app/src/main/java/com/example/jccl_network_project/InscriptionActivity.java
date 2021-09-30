package com.example.jccl_network_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;


import android.widget.Toast;

import com.example.jccl_network_project.models.Utilisateur;
import com.example.jccl_network_project.utils.FirebaseUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private TextInputLayout emailEditText, usernameEditText;
    Button suite_inscription;
    private String memail, muser_name, muser_status;
    private Spinner spinner;
    EditText nomEditText;
    String nom, email, statut_utilisateur;
    Boolean validation;

    TextView continue_button;
    public static final String TAGuid ="uid";

    private FirebaseAuth mAuth;

    public static final String TAGusername ="username";
    public static final String TAGstatus ="userstatus";
    public static final String TAGemail ="email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        //ActionBar act;
      //  act=getSupportActionBar();
       // ColorDrawable cd=new ColorDrawable(Color.parseColor("#993300"));

       // act.setBackgroundDrawable(cd);
       // getSupportActionBar().hide();

     //view associations
try{

        spinner = findViewById(R.id.user_status);
        emailEditText=findViewById(R.id.email);
        usernameEditText=findViewById(R.id.user_name);
        suite_inscription=findViewById(R.id.suite_button);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


            spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



        suite_inscription.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(InscriptionActivity.this,"value has been registered",Toast.LENGTH_LONG).show();

                memail = emailEditText.getEditText().getText().toString();
                muser_name=usernameEditText.getEditText().getText().toString();


               // Utilisateur user=new Utilisateur(muser_name,memail,muser_status);
               // FirebaseUtils.addTask(user);
                Toast.makeText(InscriptionActivity.this, "user added successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));



            }
        });



}catch (Exception e){
    Toast.makeText(InscriptionActivity.this,e.toString(),Toast.LENGTH_LONG).show();
    Log.d("erreur",e.toString());
}




    }






    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


       // String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        muser_status=adapterView.getSelectedItem().toString();
        if(muser_status=="Etudiant"||muser_status=="Eleve"){
            validation=true;
        }else{
            validation=false;
        }


    }


    public void onNothingSelected(AdapterView<?> adapterView) {
    }





    public void sendTomain(){
        startActivity(new Intent(InscriptionActivity.this,MainActivity.class));

    }

}