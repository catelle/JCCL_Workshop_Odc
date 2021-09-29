package com.example.jccl_network_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //********** Declaration des variables *************//


    //edit profile variables

    public static final String TAGprofession="profession";
    public static final String TAGusername="username";
    public static final String TAGlocalisation="localisation";
    public static final String TAGprofile_image="profile_image";
    public static final String TAGabonnee="abonnees";
    public static final String TAGfavoris="favoris";
    public static final String TAGApropos="Apropos";

     private BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener( navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new Home_fragment()).commit();

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