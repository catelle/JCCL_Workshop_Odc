package com.example.jccl_network_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.jccl_network_project.Profil_fragment.TAGlocalisation;
import static com.example.jccl_network_project.Profil_fragment.TAGnom;
import static com.example.jccl_network_project.Profil_fragment.TAGprofession;

public class EditActivity extends AppCompatActivity implements OnviewHolderCallback {

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
        adapter = new General_adapter(this, this , list ,R.layout.formation_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this ,RecyclerView.VERTICAL , false);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

        Intent data=getIntent();
        getSupportActionBar().hide();
        nomET=findViewById(R.id.edit_nom);
        professionET=findViewById(R.id.edit_profession);
        descriptionET=findViewById(R.id.edit_description);
        validation=findViewById(R.id.save_info_button);
       add_formation_button=findViewById(R.id.btn_add_formation);
       emailET=findViewById(R.id.edit_email);
       villeET=findViewById(R.id.edit_ville);
       villeET.setText(data.getStringExtra(TAGlocalisation));
       nomET.setText(data.getStringExtra(TAGnom));
       professionET.setText(data.getStringExtra(TAGprofession));

       professionET.setText(data.getStringExtra(TAGprofession));

       validation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String nom=nomET.getText().toString();
               String profession=professionET.getText().toString();
               String description=descriptionET.getText().toString();
               String email=emailET.getText().toString();
               String ville=villeET.getText().toString();
               DocumentReference  docref=db.collection("Utilisateur").document(mAuth.getUid());
               Map<String,Object> edited=new HashMap<>();
               edited.put("email",email);
               edited.put("nom",nom);
               edited.put("description",description);
               edited.put("profession",profession);
               edited.put("loclisation",ville);
               Toast.makeText(EditActivity.this,"user information edited successfully",Toast.LENGTH_LONG).show();




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