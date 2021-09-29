package com.example.jccl_network_project;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

public class ViewOtherProfileActivity extends AppCompatActivity {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView iconEdit_image,mprofile_image,camera;
    private TextView username,profession, localisation,maproposTextview, mAbonneeTextView,mFavorisTextView;
    private String usernametext,professionText, localisationText;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // ********************* Declarations variables **********************//
    TabLayout tabLayout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_other_profile);


        tabLayout =  (TabLayout) findViewById(R.id.tabLayout);
        viewPager2 = (ViewPager2)findViewById(R.id.viewpager2);

        FragmentManager fm = new FragmentManager() {

        };
        Tab_fragment_Adapter adapter = new Tab_fragment_Adapter(fm , getLifecycle());
        viewPager2.setAdapter(adapter);
        //getting profil parameters to edit
        camera=findViewById(R.id.icon_camera);
        profession=findViewById(R.id.profession);
        username=findViewById(R.id.user_name);
        localisation=findViewById(R.id.localisation);
        iconEdit_image= findViewById(R.id.icon_edit);
        mprofile_image= findViewById(R.id.user_picture);
        maproposTextview=findViewById(R.id.apropos_textview);
        mAbonneeTextView=findViewById(R.id.abonnéeTextView);
        iconEdit_image.setVisibility(View.INVISIBLE);
        camera.setVisibility(View.INVISIBLE);




        tabLayout.addTab(tabLayout.newTab().setText("Abonnees"));
        tabLayout.addTab(tabLayout.newTab().setText("A propos"));
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);

    }

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