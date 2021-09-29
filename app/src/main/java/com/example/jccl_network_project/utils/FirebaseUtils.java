package com.example.jccl_network_project.utils;


import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.jccl_network_project.models.Publication;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseUtils {

    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String COLLECTION_PUBLICATION = "publication";
    private static Publication publication;


    public static void getAllPublication() {

        db.collection("publication")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                    }
                });
    }

    public static void getUser() {

    }

    public static void getAllUsers() {

    }



}
