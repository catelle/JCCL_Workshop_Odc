package com.example.jccl_network_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText phone, mdp;
    Button send_code_button;
    CardView connectionwithFacebook_button,google_connection_button;
    TextView Email_connection_button ;
    EditText mphone_number_EditText;
    private FirebaseAuth mAuth;
    // ...
    private String country_code, phone_number;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallback;

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar act;
        act=getSupportActionBar();
        ColorDrawable cd=new ColorDrawable(Color.parseColor("#FFFFFF"));


        act.setBackgroundDrawable(cd);

        //Views Association
        Spinner spinner = (Spinner) findViewById(R.id.phone_number_spinner);
        send_code_button=findViewById(R.id.send_verification_code_button);
        connectionwithFacebook_button=findViewById(R.id.cardviewfacebook);
        Email_connection_button=findViewById(R.id.connexion_with_email_button);
        google_connection_button = findViewById(R.id.cardviewfacebook);
        mphone_number_EditText=findViewById(R.id.phone_number_editText);

        //FirebaseAuth instance

        mAuth = FirebaseAuth.getInstance();

        //response to clic on send verification code button

        send_code_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String country_code = getCountryCode();
              String phoneT = mphone_number_EditText.getText().toString();
              String phone_number = country_code+phoneT;

                if(!country_code.isEmpty()){
                    if(!phoneT.isEmpty()){
                        PhoneAuthOptions options= PhoneAuthOptions.newBuilder(mAuth)
                                //we should replace phone_number by phone edit text content
                                .setPhoneNumber("+237657273247")
                                .setTimeout(60L, TimeUnit.SECONDS)
                                .setActivity(LoginActivity.this)
                                .setCallbacks(mcallback)
                                .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);

                    }
                }
                mcallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signIn(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"OTP code has been send",Toast.LENGTH_LONG).show();
                                Intent otpIntent =new Intent(LoginActivity.this,OTPActivity.class);
                                otpIntent.putExtra("auth",s);
                                startActivity(otpIntent);
                            }

                        },1000);

                    }
                };


            }
        });


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_names, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        }

        //Country code getters and setters
            public void setCountry_code(String country_code){
                this.country_code=country_code;
            }
            public String getCountryCode(){

                    return this. country_code;
            }
        //spinner item selection listener
            public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long id) {

                             parent.getItemAtPosition(pos);
                           if(parent.getSelectedItem().toString().equals("Cameroun")){
                               setCountry_code("+237");

                           }else if(parent.getSelectedItem().toString().equals("Congo")){

                           }else if(parent.getSelectedItem().toString().equals("Gabon")){

                           }else if(parent.getSelectedItem().toString().equals("Togo")){

                           }
                           else if(parent.getSelectedItem().toString().equals("France")){

                           }
                           else if(parent.getSelectedItem().toString().equals("USA")){

                           }
                           else if(parent.getSelectedItem().toString().equals("Allemagne")){

                           }
                           else if(parent.getSelectedItem().toString().equals("Suisse")){

                           }






    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();

        if(user!=null){
            sendTomain();
        }
    }


    public void sendTomain(){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }
    private void signIn(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendTomain();
                }else{
                    Toast.makeText(LoginActivity.this,"task failed",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void SendVerificationCode(View view) {
    }

    public void connexionWithFacebookAccount(View view) {
    }

    public void connexionWithGoogleAccount(View view) {
    }

    public void inscriptionbutton(View view) {
    }

    public void connexionWithEmail(View view) {
    }


}

