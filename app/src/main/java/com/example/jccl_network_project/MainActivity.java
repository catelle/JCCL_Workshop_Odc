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

    BottomNavigationView bottomNavigation;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tabLayout =  findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewpager2);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener( navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new Home_fragment()).commit();

        FragmentManager fm = getSupportFragmentManager();
        Tab_fragment_Adapter adapter = new Tab_fragment_Adapter(fm , getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Historique"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoris"));
        tabLayout.addTab(tabLayout.newTab().setText("Abonnees"));
        tabLayout.addTab(tabLayout.newTab().setText("A propos"));
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);

    }

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
            viewPager2.setCurrentItem(tab.getPosition());
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
}