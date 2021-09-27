package com.example.jccl_network_project.utils;

import android.util.Log;

import com.example.jccl_network_project.models.Utilisateur;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;

public class FirebaseUtils {


    static final String TASK_COLLECTION = "Utilisateur";
    static CollectionReference mRefCollection;


    public  static CollectionReference getReferenceFirestore(String collectionName){
        if (mRefCollection == null){
            FirebaseFirestore db =  FirebaseFirestore.getInstance();
            mRefCollection = db.collection(collectionName);
            return mRefCollection;
        }
        return mRefCollection;
    }
    public  static  void addTask(Utilisateur user){
        FirebaseUtils.getReferenceFirestore(TASK_COLLECTION)

                .add(user)

                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG_SUCCESS","Task added successfully");


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG_FAILURE", "Task has not been added", e);
                    }
                });

    }


}
