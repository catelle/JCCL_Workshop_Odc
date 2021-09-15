package com.example.jccl_network_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nomUtilisateurEditText;
    EditText emailEditText ;
    Spinner spinner ;
    TextView continuer_button;



    BottomNavigationView bottomNavigation;
    private ActionBar tabLayout;
    private Spinner viewPager2, viewPager1;
    private String email,nomUtilisateur, status;




    //********** Declaration des variables *************//
     private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// instanciation des éléments de la vue d'inscription

        EditText nomUtilisateurEditText = findViewById(R.id.nomutilisateureditText);
        EditText emaileditText = findViewById(R.id.emaileditText);
        Spinner spinner = findViewById(R.id.label_spinner);
        TextView continuer_button = findViewById(R.id.continue_bouton);

        //clic sur le bouton continué

        continuer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email= emailEditText.getText().toString();
                nomUtilisateur = nomUtilisateurEditText.getText().toString();

            }
        });

        getSupportActionBar().hide();

        FragmentManager fm = getSupportFragmentManager();
        Tab_fragment_Adapter adapter = new Tab_fragment_Adapter(fm , getLifecycle());
        viewPager2.setAdapter((SpinnerAdapter) adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Historique"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoris"));
        tabLayout.addTab(tabLayout.newTab().setText("Abonnees"));
        tabLayout.addTab(tabLayout.newTab().setText("A propos"));
       //tabLayout.addOnTabSelectedListener(tabSelectedListener);
       // viewPager2.registerOnPageChangeCallback(pageChangeCallback);


        ArrayAdapter<CharSequence> adapterStatus = ArrayAdapter.createFromResource(this, R.array.status_utilisateur, android.R.layout.simple_spinner_item);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterStatus);
        spinner.setOnItemSelectedListener(this);

    }

    // Declaration du navigationItemSelectedListener pour la gestion des click
    // des click sur la bottom navigation
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment = null;

                    switch (item.getItemId()){
                        case R.id.home_fragment:
                            fragment = new Home_fragment();
                            break;
                        case R.id.notification_fragment:
                            fragment = new Notification_fragment();
                            break;
                        case R.id.profil_fragment:
                            fragment = new Profil_fragment();
                            break;
                        case R.id.forum_fragment:
                            fragment = new Forum_fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , fragment).commit();
                    return true;
                }
            };


    private TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
           // viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    private ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            tabLayout.selectTab(tabLayout.getTabAt(position));
        }
    };




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        status= adapterView.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

   }

