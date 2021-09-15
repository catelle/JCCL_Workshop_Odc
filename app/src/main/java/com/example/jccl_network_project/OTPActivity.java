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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPActivity extends AppCompatActivity {

    private EditText mOtpcodeEditText;

    private Button mcodeButton;
    private FirebaseAuth mAuth;
    private String OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
//changing action bar color
        ActionBar act;
        act=getSupportActionBar();
        ColorDrawable cd=new ColorDrawable(Color.parseColor("#FFFFFF"));


        act.setBackgroundDrawable(cd);

        mcodeButton=findViewById(R.id.sendCodeButton);
        mOtpcodeEditText=findViewById(R.id.otp_code_EditText);
        mAuth=FirebaseAuth.getInstance();
        OTP=getIntent().getStringExtra("auth");

        mcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verification_code=mOtpcodeEditText.getText().toString();
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
        startActivity(new Intent(OTPActivity.this,MainActivity.class));
        finish();
    }


    public void ConfirmVerificationCode(View view) {
    }
}