package com.example.jccl_network_project.detail_pages;

import static android.content.ContentValues.TAG;
import static com.example.jccl_network_project.MainActivity.ELTTOSHOW;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.CreatePublicationActivity;
import com.example.jccl_network_project.InscriptionActivity;
import com.example.jccl_network_project.MainActivity;
import com.example.jccl_network_project.R;
import com.example.jccl_network_project.adapters.GeneralRecyclerAdapter;
import com.example.jccl_network_project.custom_interface.OnItemClickListener;

import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.models.Fil_discussion;
import com.example.jccl_network_project.models.Publication;
import com.example.jccl_network_project.models.Utilisateur;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;


public class ProductActivity extends AppCompatActivity implements OnViewHolderCallback {


    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<Fil_discussion> mForumList = new LinkedList<>();
    private List<Object> mCategory = new ArrayList<>();
    private List<Object> list = new ArrayList<>();
    RecyclerView mRecyclerViewWord;
    String typeContain;
    private TextView mAppBarTitle;
    private EditText mSearchField;
    private ImageView mFilter;
    private final Map<String, String> collection = new HashMap<>();
    private final Map<String, String> listTypeContain = new HashMap<>();

    //pour le module de recherche
    List<Object> updateList = new ArrayList<>();


    //Adapter
    /*Categorie*/
    GeneralRecyclerAdapter wordAdapter;

    /*Contenu*/
    GeneralRecyclerAdapter profilAdapter;
    GeneralRecyclerAdapter docAdapter;


    // request_code envoyer aux recyclerview pour effectuer la verification dans les fonctions overrider
    private final String REQUEST_CODE_ADAPTER_PROFIL = "profil";
    private final String REQUEST_CODE_ADAPTER_CATEGORY = "categorie";
    private final String REQUEST_CODE_ADAPTER_PUBLICATION = "publication";

    // fire base instance
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();


    // Bind view for the different adapter
    /*Category_item*/
    private TextView wordItemView;

    /*Profil_item*/
    private ImageView img_profil;
    private TextView name;
    private TextView skill;

    /*Publication_item*/
    private ImageView img_doc;
    private ImageView img_poster;
    private TextView title_doc;
    private TextView description_doc;
    private TextView name_poster;
    private TextView type_doc;
    private TextView isFree;
    private TextView note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mAppBarTitle = findViewById(R.id.text_appBarTitle);
        mFilter = findViewById(R.id.image_filter);
        mSearchField = findViewById(R.id.edit_search);
        Intent data= getIntent();
        typeContain = "publication";




        /*bind map data to collection and different contains*/
        collection.put("publication", "publication");
        collection.put("user", "Utilisateur");
        collection.put("fil_discussion", "Fil_discussion");
        collection.put("category", "Categorie");

        listTypeContain.put("publication", "publication");
        listTypeContain.put("enseignant", "enseignant");
        listTypeContain.put("encadreur", "encadreur");
        listTypeContain.put("fil_discussion", "fil_discussion");

        /*Initialize all adapter*/
        profilAdapter = new GeneralRecyclerAdapter(this, this, list, R.layout.teacher_item, REQUEST_CODE_ADAPTER_PROFIL);
        docAdapter = new GeneralRecyclerAdapter(this, this, list, R.layout.document_item, REQUEST_CODE_ADAPTER_PUBLICATION);
        wordAdapter = new GeneralRecyclerAdapter(this, this, mCategory, R.layout.word_category, REQUEST_CODE_ADAPTER_CATEGORY);


        /*Permet de reccuperer les differentes categorie selon le contenu de l'intent
         * recupperer*/
        getAllCategory(typeContain);

        /*Modifie le titre le titre de la toolbar en fonction du resultat du contenu*/
        switch (typeContain) {
            case "publication":
                getAllProduct(collection.get("publication"), "..", "");
                mAppBarTitle.setText("Publication");
                break;
            case "enseignant":

                getAllProduct(collection.get("user"), "categorie", "enseignant");
                mAppBarTitle.setText("Profil Enseignant");
                break;
            case "encadreur":

                getAllProduct(collection.get("user"), "categorie", "encadreur");
                mAppBarTitle.setText("Profil encadreur");
                break;
            case "discussion":
                mAppBarTitle.setText("Fil de discussion");
                getAllProduct(collection.get("fil_discussion"), "", "");
            default:
                break;
        }

        mFilter.setOnClickListener(v -> createBottomSheetDialog());

        mSearchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchProcess(editable.toString().toLowerCase(Locale.ROOT));

            }


        });

    }

    private void searchProcess(String field) {
        List<Object> newList = new ArrayList<>();

        for (Object value : updateList) {
            switch (typeContain) {
                case "publication":
                    if (list.size() > 0)
                        list.clear();
                    if (((Publication) value).getCategorie().toLowerCase(Locale.ROOT).contains(field) || ((Publication) value).getDescription().toLowerCase(Locale.ROOT).contains(field) ||
                            ((Publication) value).getTitre().toLowerCase(Locale.ROOT).contains(field)) {
                        newList.add(value);
                        for (Object v : newList) {
                            list.add(v);
                        }
                    }
                    Log.d("***search", field + "");
                    break;
                case "enseignant":

                    break;
                case "encadreur":

                    break;
                case "discussion":

                default:
                    break;
            }
        }
        docAdapter.notifyDataSetChanged();
    }

    private void createBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.Theme_Design_BottomSheetDialog);
        bottomSheetDialog.setContentView(R.layout.activity_inscription);
        bottomSheetDialog.setOnCancelListener(dialogInterface -> dialogInterface.cancel());
        bottomSheetDialog.show();
    }

    //Permet de creer le recyler pour les profils
    private void createRecyclerProfil() {

        RecyclerView recyclerViewProfil = findViewById(R.id.recyclerview_grid);
        recyclerViewProfil.setAdapter(profilAdapter);
        RecyclerView.LayoutManager linearLayoutProfil = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewProfil.setLayoutManager(linearLayoutProfil);
        recyclerViewProfil.notify();
    }

    //Permet de creer le recycler pour les publications
    private void createRecyclerPublication() {
        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
        docAdapter = new GeneralRecyclerAdapter(this, this, list, R.layout.document_item, REQUEST_CODE_ADAPTER_PUBLICATION);
        recyclerViewDoc.setAdapter(docAdapter);
        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewDoc.setLayoutManager(linearLayoutDoc);
    }

    private void createRecyclerFilDiscussion() {

    }


    private void createRecyclerCategorie() {
        mRecyclerViewWord = findViewById(R.id.recyclerview_word);
        wordAdapter = new GeneralRecyclerAdapter(this, this, mCategory, R.layout.word_category, REQUEST_CODE_ADAPTER_CATEGORY);
        mRecyclerViewWord.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewWord.setAdapter(wordAdapter);
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
                        list.add((Utilisateur) utilisateur);
                    }
                    Log.d("***** profil charger ", list + "");
                    createRecyclerProfil();
                }).addOnFailureListener(task -> {
            Log.d(TAG, "erreur lors de la reccuperation des donnees relatives aux profils ");
        });
    }

    /**
     * TODO : review a pratique to optimise a fonction that to obtain all kine data colloction in firebase
     */
    public void getAllProduct(String collection, String field, String select) {
        db.collection(collection)
                .get()
                .addOnCompleteListener(task -> {
                    if (list.size() > 0) {
                        list.clear();
                    }
                    for (DocumentSnapshot document : task.getResult()) {
                        switch (typeContain) {
                            case "publication":
                                Publication publication = document.toObject(Publication.class);
                                list.add(publication);
                                createRecyclerPublication();

                                /* Implementer pour le module de recherche */
                                for (Object value: list) {
                                    updateList.add(value);
                                }
                                break;
                            case "enseignant":
                            case "encadreur":
                                Utilisateur utilisateur = document.toObject(Utilisateur.class);
                                list.add(utilisateur);
                                createRecyclerProfil();break;
                            case "discussion":
                                Fil_discussion fil_discussion = document.toObject(Fil_discussion.class);
                                list.add(fil_discussion);
                                createRecyclerFilDiscussion();
                                break;
                            default:
                                break;
                        }

                    }
                    Log.d("***** publication charger ", list + "");
                }).addOnFailureListener(task -> {
            Log.d("******** error", "erreur lors de la reccuperation des donnees relatives aux categorie ");
        });
    }

    /**
     * @param category : represente la collection categorie au niveau de
     *                 de la base de donnees
     */
    public void getAllCategory(String category) {
        db.collection("Categorie")
                .get()
                .addOnCompleteListener(task -> {
                    for (DocumentSnapshot document : task.getResult()) {
                        mCategory = (List<Object>) document.get(category);
                    }
                    Log.d("********** tableau charger", mCategory + " ");
                    createRecyclerCategorie();
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

    public void getSelectCategory(String collection, String field, String select) {
        db.collection(collection)
                .whereEqualTo(field, select)
                .get()
                .addOnCompleteListener(task -> {
                    if (list.size() > 0) {
                        list.clear();
                    }
                    for (DocumentSnapshot document : task.getResult()) {
                        switch (typeContain) {
                            case "publication":
                                Publication publication = document.toObject(Publication.class);
                                list.add(publication);
                                break;
                            case "etudiant":
                                Utilisateur utilisateur = document.toObject(Utilisateur.class);
                                list.add(utilisateur);
                                break;
                            case "enseignant":

                                break;
                            case "discussion":
                                Fil_discussion fil_discussion = document.toObject(Fil_discussion.class);
                                list.add(fil_discussion);
                                break;
                            default:
                                break;
                        }
                    }
                    docAdapter.notifyDataSetChanged();
                    profilAdapter.notifyDataSetChanged();

                    //TODO : add notifyDataSetChanged() for FilDiscussion

                    Log.d("***Nouvel list", list + "");
                }).addOnFailureListener(task -> {

        });
    }

    @Override
    public void setItemInformation(Object object, @Nullable String request_code) {
        switch (request_code) {
            case REQUEST_CODE_ADAPTER_CATEGORY:
                String mCurrent = (String) object;
                wordItemView.setText(mCurrent);
                break;
            case REQUEST_CODE_ADAPTER_PROFIL:
                break;
            case REQUEST_CODE_ADAPTER_PUBLICATION:
                this.title_doc.setText(((Publication) object).getTitre());
                this.description_doc.setText(((Publication) object).getDescription());
                this.name_poster.setText(((Publication) object).getPoster_id());
                this.type_doc.setText(((Publication) object).getCategorie());
//            this.note.setText((ArrayList<Integer>) currentObject.getNote());
                this.isFree.setText("free");
        }
    }

    @Override
    public void onItemClick(int position, @Nullable String request_code) {
        switch (request_code) {
            case REQUEST_CODE_ADAPTER_CATEGORY:
                String select = (String) mCategory.get(position);
                if (select != mCategory.get(0)) {
                    switch (typeContain) {
                        case "publication":
                            Intent intent=new Intent(ProductActivity.this, DetailPublication_doc.class);
                            startActivity(intent);
                            break;
                        case "enseignant":
                        case "encadreur":
                            getSelectCategory("Utilisateur", "domaine", (String) select);
                            break;
                        default:
                            break;
                    }
                } else {
                    switch (typeContain) {
                        case "publication":
                            getAllProduct("publication", "categorie", (String) select);
                            Log.d("cliquer", select + "");
                            break;
                        case "enseignant":
                        case "encadreur":
                            getSelectCategory("Utilisateur", "domaine", (String) select);
                            break;
                        default:
                            break;
                    }
                }
                break;
            case REQUEST_CODE_ADAPTER_PROFIL:
                Log.d("****Cliquer", " Profil " + position);
                Toast.makeText(this, "click sur " + position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ProductActivity.this, DetailPublication_doc.class);
                startActivity(intent);
                break;
            case REQUEST_CODE_ADAPTER_PUBLICATION:
                Log.d("****Cliquer", " publication " + position);
                Toast.makeText(this, "click sur " + position, Toast.LENGTH_SHORT).show();
                Intent intentn=new Intent(ProductActivity.this, DetailPublication_doc.class);
                startActivity(intentn);
                break;
        }
    }

    @Override
    public void bindItemView(View view, @Nullable String request_code) {
        switch (Objects.requireNonNull(request_code)) {
            case REQUEST_CODE_ADAPTER_CATEGORY:
                wordItemView = view.findViewById(R.id.item_category);
                break;
            case REQUEST_CODE_ADAPTER_PROFIL:
                img_profil = view.findViewById(R.id.img_profil);
                name = view.findViewById(R.id.name);
                skill = view.findViewById(R.id.skill);
                break;
            case REQUEST_CODE_ADAPTER_PUBLICATION:
                img_doc = view.findViewById(R.id.img_doc);
                img_poster = view.findViewById(R.id.img_poster);
                title_doc = view.findViewById(R.id.title_doc);
                description_doc = view.findViewById(R.id.description_doc);
                name_poster = view.findViewById(R.id.name_poster);
                type_doc = view.findViewById(R.id.type_doc);
                isFree = view.findViewById(R.id.isFree);
                note = view.findViewById(R.id.note);
                break;
        }
    }


    public void backToMainActivity(View view) {
        Intent intent=new Intent(ProductActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}