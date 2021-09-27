package com.example.jccl_network_project.detail_pages;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.detail_pages.WordCategoryAdapter;
import com.example.jccl_network_project.models.Publication;
import com.example.jccl_network_project.models.Utilisateur;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ProductActivity extends AppCompatActivity {

    private List<String> mCategory = new ArrayList<>();
    private List<Object> list = new ArrayList<>();
    private TextView mAppBarTitle;
    RecyclerView mRecyclerViewWord;
    String typeContain;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mAppBarTitle = findViewById(R.id.text_appBarTitle);
        mRecyclerViewWord = findViewById(R.id.recyclerview_word);
        typeContain = "enseignant";

        /*Permet de reccuperer les differentes categorie selon le contenu de l'intent
         * recupperer*/
        getAllCategory(typeContain);

        /*Modifie le titre le titre de la toolbar en fonction du resultat du contenu*/
        switch (typeContain) {
            case "publication":
                getAllPublication();
                mAppBarTitle.setText("Publication");
                break;
            case "enseignant":
                mAppBarTitle.setText("Profil Enseignant");
                getAllProfil("enseignant");
                break;
            case "profil encadreur":
                mAppBarTitle.setText("Profil encadreur");
                getAllProfil("encadreur");
                break;
            default:
                break;
        }

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this , R.style.Base_V14_ThemeOverlay_MaterialComponents_MaterialAlertDialog);
        bottomSheetDialog.setContentView(R.layout.document_item);
        bottomSheetDialog.setDismissWithAnimation(false);
        bottomSheetDialog.show();

    }

    //Permet de creer le recyler pour les profils
    private void createRecyclerProfil() {

        RecyclerView recyclerViewProfil = findViewById(R.id.recyclerview_grid);
        ProfilAdapter profilAdapter = new ProfilAdapter(this, list);
        recyclerViewProfil.setAdapter(profilAdapter);
        RecyclerView.LayoutManager linearLayoutProfil = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewProfil.setLayoutManager(linearLayoutProfil);
    }

    //Permet de creer le recycler pour les publications
    private void createRecyclerPublication() {
        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
        DocumentAdapter docAdapter = new DocumentAdapter(this, list);
        recyclerViewDoc.setAdapter(docAdapter);
        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewDoc.setLayoutManager(linearLayoutDoc);
    }

    private void createRecyclerCategorie() {
        WordCategoryAdapter wordAdapter = new WordCategoryAdapter(this, mCategory);
        mRecyclerViewWord.setAdapter(wordAdapter);
        mRecyclerViewWord.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
    }

    /**
     * @param category represente le type de profil concerner
     */
    public void getAllProfil(String category) {
        db.collection("Utilisateur")
                .whereEqualTo("categorie", category)
                .get()
                .addOnCompleteListener(task -> {
                    for (DocumentSnapshot document : task.getResult()) {
                        Utilisateur utilisateur = document.toObject(Utilisateur.class);
                        list.add((Utilisateur)utilisateur);
                    }
                    Log.d("***** profil charger ", list + "");
                    createRecyclerProfil();
                }).addOnFailureListener(task -> {
            Log.d(TAG, "erreur lors de la reccuperation des donnees relatives aux profils ");
        });
    }

    public void getAllCategory(String category) {
        db.collection("Categorie")
                .get()
                .addOnCompleteListener(task -> {
                    for (DocumentSnapshot document : task.getResult()) {
                        mCategory = (List<String>) document.get(category);
                    }
                    createRecyclerCategorie();
                    Log.d("********** tableau charger", mCategory + " ");
                }).addOnFailureListener(task -> {
            Log.d("******** error", "erreur lors de la reccuperation des donnees relatives aux profil ");
        });
    }

    public void getAllPublication() {
        db.collection("publication")
                .get()
                .addOnCompleteListener(task -> {
                    for (DocumentSnapshot document : task.getResult()) {
                        Publication publication = document.toObject(Publication.class);
                        list.add(publication);
                    }
                    createRecyclerPublication();
                    Log.d("***** publication charger ", list + "");
                }).addOnFailureListener(task -> {
            Log.d("******** error", "erreur lors de la reccuperation des donnees relatives aux categorie ");
        });
    }
}