package com.example.jccl_network_project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jccl_network_project.adapters.General_adapter;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity implements OnviewHolderCallback {

    List<Object> list;
    General_adapter adapter;
    RecyclerView recycler;

    EditText etnom,etProfession, etDescription;
    Button btnValider;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //DatabaseReference reference;
    DocumentReference documentReference;
    private String currentuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etnom = findViewById(R.id.edit_nom);
        etProfession = findViewById(R.id.edit_profession);
        etDescription = findViewById(R.id.edit_description);
        btnValider = findViewById(R.id.boutonValider);

        recycler = findViewById(R.id.recycler_formation);

        FirebaseUser Utilisateur = FirebaseAuth.getInstance().getCurrentUser();
        String currentuid = Utilisateur.getUid();

        documentReference = db.collection("Utilisateur").document(currentuid);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile();
            }
        });

        list = new ArrayList<>();
        list.add(new Formation("bonjour"));
        list.add(new Formation("bonsoir"));
        list.add(new Formation("salut"));
        list.add(new Formation("yo"));
        list.add(new Formation("Hola"));
        adapter = new General_adapter(this, this , list ,R.layout.formation_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this ,RecyclerView.VERTICAL , false);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();


        documentReference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.getResult().exists()){
                            String nomResult = task.getResult().getString("Nom");
                            String professionResult = task.getResult().getString("Profession");
                            String descriptionResult = task.getResult().getString("Description");
                            String formationResult = task.getResult().getString("Formation");

                            //Picasso.get().load(url).into(imageView);
                            etnom.setText(nomResult);
                            etProfession.setText(professionResult);
                            etDescription.setText(descriptionResult);
                           // recycler.setTextAlignment(formationResult);
                        }
                        else{
                            Toast.makeText(EditActivity.this,"Pas de Profil",Toast.LENGTH_LONG).show();
                            //Intent intent = new Intent(getActivity(),EditActivity.class);
                            //startActivity(intent);
                        }

                    }
                });
    }

    private void updateProfile() {

        String nom = etnom.getText().toString();
        String profession = etProfession.getText().toString();
        String description = etDescription.getText().toString();

        final DocumentReference sDoc = db.collection("Utilisateur").document(currentuid);

        db.runTransaction(new Transaction.Function<Double>() {
            @Override
            public Double apply(Transaction transaction) throws FirebaseFirestoreException {
               // DocumentSnapshot snapshot = transaction.get(sDoc);
                //double newPopulation = snapshot.getDouble("population") + 1;
                //if (newPopulation <= 1000000) {
                    transaction.update(sDoc, "nom",nom);
                    transaction.update(sDoc, "profession",profession);
                    transaction.update(sDoc, "description",description);
                    return null;
               // } else {
                 //   throw new FirebaseFirestoreException("Population too high",
                           // FirebaseFirestoreException.Code.ABORTED);
              //  }
            }
        }).addOnSuccessListener(new OnSuccessListener<Double>() {
            @Override
            public void onSuccess(Double result) {
                Toast.makeText(EditActivity.this,"mise à jour",Toast.LENGTH_LONG).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditActivity.this, "échoué", Toast.LENGTH_LONG).show();
                    }
                });

    }


    @Override
    public void setFavorisViewInformation(int position) {
        EditText editText = findViewById(R.id.edit_formation);
        String edit = ((Formation) list.get(position)).getIntitule();
        editText.setText(edit);
    }

    @Override
    public List<View> getViews() {
        List<View> list = new ArrayList<>();
        View view = View.inflate(this , R.layout.formation_item,null);
        EditText edit = view.findViewById(R.id.edit_formation);
        Spinner spinner = view.findViewById(R.id.spinner_formation);
        list.add(edit);
        list.add(spinner);
        return list;
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