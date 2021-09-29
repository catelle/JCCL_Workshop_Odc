package com.example.jccl_network_project;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class ViewProfileActivity extends AppCompatActivity {

    ImageView icon_camera,user_picture, icon_edit;
    TextView username, profession, localisation;
    ViewPager2   viewPager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);



        icon_camera=findViewById(R.id.icon_camera);
        user_picture=findViewById(R.id.user_picture);
        icon_edit=findViewById(R.id.icon_edit);
        username=findViewById(R.id.user_name);
        profession=findViewById(R.id.profession);
        localisation=findViewById(R.id.localisation);
        tabLayout =  (TabLayout)findViewById(R.id.tabLayout);
        viewPager2=(ViewPager2)findViewById(R.id.viewpager2);


        FragmentManager fm=new FragmentManager() {

        };
        Tab_fragment_Adapter adapter = new Tab_fragment_Adapter(fm , getLifecycle());
        viewPager2.setAdapter(adapter);



        tabLayout.addTab(tabLayout.newTab().setText("Abonnees"));
        tabLayout.addTab(tabLayout.newTab().setText("A propos"));
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);



    }


    @Override
    protected void onStart() {
        super.onStart();

        icon_camera.setVisibility(View.INVISIBLE);
        icon_edit.setVisibility(View.INVISIBLE);


    }


    private ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            tabLayout.selectTab(tabLayout.getTabAt(position));
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
}
