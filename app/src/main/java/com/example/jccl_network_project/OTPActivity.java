package com.example.jccl_network_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.models.Utilisateur;
import com.example.jccl_network_project.utils.FirebaseUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import static com.example.jccl_network_project.InscriptionActivity.TAGemail;
import static com.example.jccl_network_project.InscriptionActivity.TAGstatus;
import static com.example.jccl_network_project.InscriptionActivity.TAGusername;

import static com.example.jccl_network_project.LoginActivity.TAGphonenumber;

public class OTPActivity extends AppCompatActivity {
    private EditText msendcodeEditText;

    private Button mcodeButton;
    private FirebaseAuth mAuth;
    private String OTP;
    TextView continuebutton;
    private  String userid;
    private String nom;
    private String statut_utilisateur;
    private String email;
    private Boolean valider;
    private  Intent data;
    private String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);


        ActionBar act;
        act=getSupportActionBar();
        ColorDrawable cd=new ColorDrawable(Color.parseColor("#993300"));


        act.setBackgroundDrawable(cd);
        continuebutton=findViewById(R.id.continue_button);
        msendcodeEditText=findViewById(R.id.phone_number);
        mAuth=FirebaseAuth.getInstance();
        Intent data=getIntent();
        OTP=data.getStringExtra("auth");
        userid=data.getStringExtra(TAGusername);
        nom=data.getStringExtra(TAGusername);

        statut_utilisateur=data.getStringExtra(TAGstatus);
        email=data.getStringExtra(TAGemail);

         phoneNum=data.getStringExtra(TAGphonenumber);
         if(statut_utilisateur.equals("Etudiant")||statut_utilisateur.equals("Eleve")){
             valider=true;
         }else{
             valider=false;
         }

        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verification_code=msendcodeEditText.getText().toString();
                if(!verification_code.isEmpty()){
                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(OTP,verification_code);
                    signIn(credential);
                }else{
                    Toast.makeText(OTPActivity.this,"Please enter OTP",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void signIn(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendTomain();
                }else{
                    Toast.makeText(OTPActivity.this," verification failed",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if(currentUser!=null){
            sendTomain();
        }
    }

    public void sendTomain(){
        Utilisateur user=new Utilisateur(userid,nom,phoneNum,statut_utilisateur,email,valider);
        FirebaseUtils.addTask(user);
        Toast.makeText(OTPActivity.this,"Vous etes desormais utilisateur du systeme",Toast.LENGTH_LONG);
        startActivity(new Intent(OTPActivity.this,MainActivity.class));
        finish();
    }

    public void resendconfirmationemailfunction(View view) {
    }

    public void sendThecodefunction(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
