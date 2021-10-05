package com.example.jccl_network_project;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import com.example.jccl_network_project.models.Utilisateur;
import com.example.jccl_network_project.utils.FirebaseUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;


import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;


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
    private TextInputLayout emailEditText, usernameEditText;
    Button suite_inscription;
    private String memail, muser_name, muser_status;
    private Spinner spinnerstatus;
    EditText nomEditText;
    String nom, email, statut_utilisateur;
    String validation;

    TextView continue_button;
    public static final String TAGuid ="uid";


    public static final String TAGusername ="username";
    public static final String TAGstatus ="userstatus";
    public static final String TAGemail ="email";
    public static final String TAGphone ="phone";
    public static final String TAGvalidation ="phone";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        //Views Association
        Spinner spinner = (Spinner) findViewById(R.id.phone_number_spinner);
        send_code_button=findViewById(R.id.send_verification_code_button);
        connectionwithFacebook_button=findViewById(R.id.cardviewfacebook);
        Email_connection_button=findViewById(R.id.connexion_with_email_button);
        google_connection_button = findViewById(R.id.cardviewfacebook);
        mphone_number_EditText=findViewById(R.id.phone_number_editText);
        spinnerstatus = findViewById(R.id.user_status);
        emailEditText=findViewById(R.id.email);
        usernameEditText=findViewById(R.id.user_name);
        suite_inscription=findViewById(R.id.suite_button);

        //FirebaseAuth instance

        mAuth = FirebaseAuth.getInstance();

        //response to clic on send verification code button
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
                        otpIntent.putExtra(TAGemail,memail);
                        otpIntent.putExtra(TAGusername,muser_name);
                        otpIntent.putExtra(TAGstatus,muser_status);
                        otpIntent.putExtra(TAGphone,phone_number);
                        otpIntent.putExtra(TAGvalidation,validation);


                        startActivity(otpIntent);
                    }

                },1000);

            }
        };
        send_code_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String country_code = getCountryCode();
              String phoneT = mphone_number_EditText.getText().toString();
              phone_number = country_code+phoneT;


                memail = emailEditText.getEditText().getText().toString();
                muser_name=usernameEditText.getEditText().getText().toString();







                if(!(country_code.isEmpty())){
                    if(!(phoneT.isEmpty())){
                        try{
                            PhoneAuthOptions options= PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber("+237657273247")
                                    .setTimeout(60L, TimeUnit.SECONDS)
                                    .setActivity(LoginActivity.this)
                                    .setCallbacks( mcallback)
                                    .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);

                        }catch(Exception e){
                            Toast.makeText(LoginActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                        }

                    }
                }



            }
        });


// Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> adapterstatus = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);

        adapterstatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerstatus.setAdapter(adapterstatus);

        spinnerstatus.setOnItemSelectedListener(this);


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
                switch(parent.getId()){
                    case R.id.phone_number_spinner:


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
                           break;
                    case R.id.user_name:
                        muser_status=parent.getSelectedItem().toString();
                        if(muser_status=="Etudiant"||muser_status=="Eleve"){
                            validation="true";
                        }else{
                            validation="false";
                        }
                        break;
                }





    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  FirebaseUser user=mAuth.getCurrentUser();
        

      //  if(user!=null){
           // sendTomain();
      //  }
    }

    public void signIn(PhoneAuthCredential credential){
        Toast.makeText(LoginActivity.this,"sign in method",Toast.LENGTH_LONG).show();
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

    public void sendTomain(){
        Toast.makeText(LoginActivity.this,"problem in sendtomain",Toast.LENGTH_LONG).show();
        startActivity(new Intent(LoginActivity.this,MainActivity.class));

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


