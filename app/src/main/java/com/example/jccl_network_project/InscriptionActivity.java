package com.example.jccl_network_project;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.models.Utilisateur;
import com.example.jccl_network_project.utils.FirebaseUtils;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText emailEditText, usernameEditText;
    TextView continuer_inscription;
    private String memail, muser_name,muser_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


     //view associations

        Spinner spinner = findViewById(R.id.user_status);
        emailEditText=findViewById(R.id.email);
        usernameEditText=findViewById(R.id.name);
        continuer_inscription=findViewById(R.id.continue_button);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    // continue button oncliskListenner

        continuer_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recuparation of the different components values

                memail = emailEditText.getText().toString();
                muser_name=usernameEditText.getText().toString();
                Utilisateur user=new Utilisateur(muser_name,memail,muser_status);
                FirebaseUtils.addTask(user);
                Toast.makeText(InscriptionActivity.this, "user added successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();


            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        muser_status=adapterView.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}