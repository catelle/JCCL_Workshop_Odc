package com.example.jccl_network_project.utils;




import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jccl_network_project.InscriptionActivity;
import com.example.jccl_network_project.models.Publication;
import com.example.jccl_network_project.models.Utilisateur;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


import androidx.annotation.NonNull;

import android.os.Parcelable;
import android.util.Log;
import com.example.jccl_network_project.models.Publication;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import static com.github.vipulasri.timelineview.TimelineView.TAG;

public class FirebaseUtils {


    static final String TASK_COLLECTION = "Utilisateur";
    static final String PUBLICATION_COLLECTION = "publication";
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

try{

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
}catch(Exception e){

}



    }
                        public static void getAllPublication() {

                            FirebaseFirestore.getInstance().collection("publication")
                                    .get()
                                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                        @Override
                                        public void onSuccess(QuerySnapshot snapshots) {



                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("TAG_FAILURE", "Task has not been added", e);
                                        }
                                    });







                        }
    public  static  void addPublication(Publication publication){
        FirebaseUtils.getReferenceFirestore(PUBLICATION_COLLECTION)

                .add(publication)

                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override

                    public void onSuccess(DocumentReference documentReference) {

                        Log.d("TAG_SUCCESS","Task added successfully");
                        DocumentReference washingtonRef = FirebaseFirestore.getInstance().collection("utilisateur").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

// Set the "isCapital" field of the city 'DC'
                        washingtonRef
                                .update("publication", publication)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot successfully updated!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error updating document", e);
                                    }
                                });





                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.w("TAG_FAILURE", "Task has not been added", e);
                    }
                });

    }






    public static void getUser() {

    }

    public static void getAllUsers() {

    }


}


