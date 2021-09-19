package com.example.jccl_network_project;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import static com.example.jccl_network_project.InscriptionActivity.TAGemail;
import static com.example.jccl_network_project.InscriptionActivity.TAGstatus;
import static com.example.jccl_network_project.InscriptionActivity.TAGuid;
import static com.example.jccl_network_project.InscriptionActivity.TAGusername;


public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText phone, mdp;
    TextView con;
    private FirebaseAuth mAuth;
    Spinner spinner;
    String country_code;
    // ...
  private  String userid;
   private String nom;
   private String statut_utilisateur;
    private String email;
    private Boolean valider;
   private  Intent data;
   private String phoneNum;
   public static final String TAGphonenumber="phone_number";
    // ...
// Initialize Firebase Auth
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar act;
        act=getSupportActionBar();
        ColorDrawable cd=new ColorDrawable(Color.parseColor("#993300"));

        act.setBackgroundDrawable(cd);

        getSupportActionBar().hide();
         data=getIntent();

        mAuth=FirebaseAuth.getInstance();
        userid=data.getStringExtra(TAGuid);
         nom=data.getStringExtra(TAGusername);
         statut_utilisateur=data.getStringExtra(TAGstatus);
         email=data.getStringExtra(TAGemail);

        phone=(EditText)findViewById(R.id.phone_number);

        con=findViewById(R.id.continue_button);
        mAuth = FirebaseAuth.getInstance();

        spinner=findViewById(R.id.spinner_country_code);


        //spinner for country codes

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_codes, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mAuth=FirebaseAuth.getInstance();

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country_code="237";
                //should be change to take the phone number from the edit text
                String phoneT=phone.getText().toString();
                phoneNum="+"+country_code+phoneT;

                if(!country_code.isEmpty()){
                    if(!phoneT.isEmpty()){
                        PhoneAuthOptions options= PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber("+237657273247")
                                .setTimeout(60L, TimeUnit.SECONDS)
                                .setActivity(LoginActivity.this)
                                .setCallbacks(mcallback)
                                .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);

                    }
                }
            }
        });
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
                        otpIntent.putExtra(TAGuid,userid);
                        otpIntent.putExtra(TAGusername,nom);
                        otpIntent.putExtra(TAGemail,email);
                        otpIntent.putExtra(TAGstatus,statut_utilisateur);

                        otpIntent.putExtra(TAGphonenumber,phoneNum);

                        startActivity(otpIntent);
                    }

                },1000);

            }
        };

    }


        protected void onStart(){
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getSelectedItem().toString().equals("Cameroun")){
            country_code="+237";
        }else if(adapterView.getSelectedItem().toString().equals("France")){
            country_code="+33";
        }else if(adapterView.getSelectedItem().toString().equals("Allemagne")){
            country_code="";
        }else if(adapterView.getSelectedItem().toString().equals("Suisse")){
            country_code="";
        }else if(adapterView.getSelectedItem().toString().equals("Congo")){
            country_code="";
        }else if(adapterView.getSelectedItem().toString().equals("Gabon")){
            country_code="";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}



