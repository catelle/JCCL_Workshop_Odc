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

public class MainActivity extends AppCompatActivity  {

   // EditText nomUtilisateurEditText;
   // EditText emailEditText ;
   // Spinner spinner ;
   // TextView continuer_button;



    private BottomNavigationView bottomNavigation;
  //  private ActionBar tabLayout;
  //  private Spinner viewPager2, viewPager1;
  //  private String email,nomUtilisateur, status;




    //********** Declaration des variables *************//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home_fragment()).commit();

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


}



