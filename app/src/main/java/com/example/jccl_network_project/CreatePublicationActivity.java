package com.example.jccl_network_project;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jccl_network_project.models.Publication;
import com.example.jccl_network_project.utils.FirebaseUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class CreatePublicationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner categoriePub,domainePub, destinantionPub,niveau_scolaire_pub;

    EditText  title_editText;
    TextInputLayout contentDescription_editText;

    EditText [] mots_clés=new EditText[5];

    ImageView uploadContent,sellcontentButton;

    ImageView uploadedImage;
    String TAG="error";

    Button create_publication_button, choose_file_button;

    String categorie, domaine, destination,titre,description,niveau;
    List<String> mots_clé;
    
    public static Boolean selled;
    
    FirebaseStorage storage;

    StorageReference storageReference;

    FirebaseFirestore db;

    FirebaseAuth mAuth;


    private Uri filePath;


    private final int PICK_IMAGE_REQUEST = 22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_publication);


//component associations
try{

        storage = FirebaseStorage.getInstance();
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        categoriePub = findViewById(R.id.categorie_pub);
        domainePub = findViewById(R.id.domaine_pub);
        destinantionPub = findViewById(R.id.destinantion_pub);
        niveau_scolaire_pub=findViewById(R.id.niveau_scolaire_pub);
        contentDescription_editText = findViewById(R.id.user_name);
        uploadContent = findViewById(R.id.upload_image_button);
        sellcontentButton = findViewById(R.id.sellcontent_button);
        create_publication_button = findViewById(R.id.create_publication);
        choose_file_button = findViewById(R.id.choosefile_button);
        title_editText=findViewById(R.id.titre_publication);

        uploadedImage=findViewById(R.id.uploadedImageView);

        mots_clés[0]=findViewById(R.id.mot_clé_1);
        mots_clés[1]=findViewById(R.id.mot_clé_2);
        mots_clés[2]=findViewById(R.id.mot_clé_3);
        mots_clés[3]=findViewById(R.id.mot_clé_4);

        selled=false;

        db=FirebaseFirestore.getInstance();

    //response to clic on create publication

    choose_file_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SelectImage();
        }
    });

    // clic on sell content button

    sellcontentButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selled=true;
            Toast.makeText(CreatePublicationActivity.this,"content will be sell",Toast.LENGTH_LONG).show();
        }
    });


    //adapters for spinners


    ArrayAdapter<CharSequence> adapterCategorie = ArrayAdapter.createFromResource(this,R.array.Categorie_array, android.R.layout.simple_spinner_item);
    adapterCategorie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    ArrayAdapter<CharSequence> adapterDomaine = ArrayAdapter.createFromResource(this,R.array.Domaine_array, android.R.layout.simple_spinner_item);
    adapterDomaine.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    ArrayAdapter<CharSequence> adapterDestination = ArrayAdapter.createFromResource(this,R.array.Destination_array, android.R.layout.simple_spinner_item);
    adapterDomaine.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    ArrayAdapter<CharSequence> adapterNiveauScolaire = ArrayAdapter.createFromResource(this,R.array.Niveau_array, android.R.layout.simple_spinner_item);
    adapterDomaine.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



    //adapters and spinners association

    domainePub.setAdapter(adapterDomaine);
    categoriePub.setAdapter(adapterCategorie);
    niveau_scolaire_pub.setAdapter(adapterNiveauScolaire);
    destinantionPub.setAdapter(adapterDestination);

    domainePub.setOnItemSelectedListener(this);
    categoriePub.setOnItemSelectedListener(this);
    niveau_scolaire_pub.setOnItemSelectedListener(this);
    destinantionPub.setOnItemSelectedListener(this);

    create_publication_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try{


                description=contentDescription_editText.getEditText().getText().toString();
            }catch (Exception e){
                Toast.makeText(CreatePublicationActivity.this,"1"+e.toString(),Toast.LENGTH_LONG).show();
            }

            try{


                titre=title_editText.getText().toString();

            }catch (Exception e){
                Toast.makeText(CreatePublicationActivity.this,"2"+e.toString(),Toast.LENGTH_LONG).show();
            }
            try{


                mots_clé.add(mots_clés[0].getText().toString());
                mots_clé.add(mots_clés[1].getText().toString());
              //  mots_clé.add(mots_clés[2].getText().toString());
               // mots_clé.add(mots_clés[3].getText().toString());

            }catch (Exception e){
                Toast.makeText(CreatePublicationActivity.this,"2"+e.toString(),Toast.LENGTH_LONG).show();
            }
            try{


                Publication publication = new Publication(mAuth.getCurrentUser().getUid(),categorie,description,destination,filePath.toString(),titre,mots_clé,niveau);
                FirebaseUtils.addPublication(publication);

            }catch (Exception e){
                Toast.makeText(CreatePublicationActivity.this,"3"+e.toString(),Toast.LENGTH_LONG).show();
            }


                Toast.makeText(CreatePublicationActivity.this,"publiction added successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(CreatePublicationActivity.this,MainActivity.class));


            uploadImage();

        }
    });

}catch(Exception e){
    Toast.makeText(CreatePublicationActivity.this,e.toString(),Toast.LENGTH_LONG).show();
    Intent intent=new Intent(CreatePublicationActivity.this,InscriptionActivity.class);
    intent.putExtra(TAG,e.toString());
}









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
                                            .makeText(CreatePublicationActivity.this,
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
                                    .makeText(CreatePublicationActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        TaskSnapshot taskSnapshot)
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



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch(adapterView.getId()){
            case R.id.domaine_pub:
                domaine=adapterView.getSelectedItem().toString();
                break;
            case R.id.categorie_pub:
                categorie=adapterView.getSelectedItem().toString();
                break;
            case R.id.niveau_scolaire_pub:
                niveau=adapterView.getSelectedItem().toString();
                break;
            case R.id.destinantion_pub:
                destination=adapterView.getSelectedItem().toString();
                break;
        }



}
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
