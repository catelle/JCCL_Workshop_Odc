package com.example.jccl_network_project;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.content.ContentValues.TAG;
import static com.example.jccl_network_project.MainActivity.TAGlocalisation;
import static com.example.jccl_network_project.MainActivity.TAGprofession;
import static com.example.jccl_network_project.MainActivity.TAGprofile_image;
import static com.example.jccl_network_project.MainActivity.TAGusername;

import com.example.jccl_network_project.adapters.General_adapter;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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
    Button save,uploddocs;
    ImageView uploadedImage;

    FirebaseAuth mauth;
    FirebaseFirestore firestore;
    FirebaseStorage storage;
    private Uri filePath;

    List<Object> list;
    General_adapter adapter;
    RecyclerView recycler;
    EditText nomET,professionET, descriptionET;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    private final int PICK_IMAGE_REQUEST = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // on doit recupere les donnée du profil qui existe deja et les placer comme hint

       Intent data=getIntent();
       nom=data.getStringExtra(TAGusername);
       localisation=data.getStringExtra(TAGlocalisation);
       profession=data.getStringExtra(TAGprofession);
        storage = FirebaseStorage.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();


                // Name, email address, and profile photo Url
                 nom = profile.getDisplayName();
                email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();

            }
        }
       nomET=findViewById(R.id.edit_nom);
        professionET=findViewById(R.id.edit_profession);
        descriptionET=findViewById(R.id.edit_description);
        uploadedImage=findViewById(R.id.uploadedImage);
        uploddocs=findViewById(R.id.uploaddocs);
        uploddocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();
            }
        });

        nomET.setText(nom);
        professionET.setText(profession);


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
               try{


               String email="catelleningha@gmail.com";
               //recuperation des données tests sur les valeurs
               DocumentReference ref=firestore.collection("Utilisateur").document(mauth.getUid());
               Map< String,Object > edited=new HashMap<>();
               edited.put("email",email);
               edited.put("profession",profession);


               FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

               UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                       .setDisplayName("Jane Q. User")
                       .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                       .build();

               user.updateProfile(profileUpdates)
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()) {
                                   Log.d(TAG, "User profile updated.");
                               }
                           }
                       });

               user.updateEmail(email)
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()) {
                                   Log.d(TAG, "User email address updated.");
                               }
                           }
                       });
               user.sendEmailVerification()
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()) {
                                   Log.d(TAG, "Email sent.");
                               }
                           }
                       });


               }catch (Exception e){
     Toast.makeText(EditActivity.this, e.toString(),Toast.LENGTH_LONG).show();
               }

           }
               });



       }



    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // UploadImage method
    private void uploadImage()
    {
        if (filePath != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference

            String fiepath= "publication/" + UUID.randomUUID().toString();

            StorageReference storageRef = storage.getReference();

            StorageReference ref
                    = storageRef.child("images/"
                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(EditActivity.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(EditActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

                        // Progress Listener for loading
                        // percentage on the dialog box
                        @Override
                        public void onProgress(
                                UploadTask.TaskSnapshot taskSnapshot)
                        {
                            double progress
                                    = (100.0
                                    * taskSnapshot.getBytesTransferred()
                                    / taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage(
                                    "Uploaded "
                                            + (int)progress + "%");
                        }
                    });
        }
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                uploadedImage.setImageBitmap(bitmap);

            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
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



