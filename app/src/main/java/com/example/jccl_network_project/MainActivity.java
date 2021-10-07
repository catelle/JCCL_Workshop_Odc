package com.example.jccl_network_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private int mCpt;
    private ImageView mButtonToNext;
    private ImageView mButtonToPrevouis;
    private ImageView mImageBrand;
    private TextView mBulletBrandThree;
    private TextView mBulletBrandOne;
    private TextView mBulletBrandTwo;
    private TextView mTextMarketBrand;
    //********** Declaration des variables *************//
    private BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener( navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new Home_fragment()).commit();

        mButtonToNext = findViewById(R.id.next_to_img);
        mButtonToPrevouis = findViewById(R.id.back_to_img);
        mImageBrand = findViewById(R.id.img_brand_home);
        mBulletBrandThree = findViewById(R.id.bullet_3);
        mBulletBrandTwo = findViewById(R.id.bullet_2);
        mBulletBrandOne = findViewById(R.id.bullet_1);
        mTextMarketBrand = findViewById(R.id.text_brand);

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

    // Gestion des clicks sur la bannière home page

    @SuppressLint("ResourceAsColor")
    public void nextImage(View view) {
        mCpt++;
        if (mCpt == 1){
            mImageBrand.setImageResource(R.mipmap.ic_commaunity);
            mBulletBrandOne.setBackgroundColor(R.color.white);
            mBulletBrandTwo.setBackgroundColor(R.color.orange);
            mTextMarketBrand.setText(R.string.text_market_forum);
        }else if(mCpt == 2){
            mImageBrand.setImageResource(R.mipmap.ic_book);
            mBulletBrandTwo.setBackgroundColor(R.color.white);
            mBulletBrandThree.setBackgroundColor(R.color.orange);
            mTextMarketBrand.setText(R.string.text_market_contenu);
        }else{
            mCpt = 0;
            mImageBrand.setImageResource(R.mipmap.ic_office_work);
            mTextMarketBrand.setText(R.string.text_market_encardreur);
            mBulletBrandOne.setBackgroundColor(R.color.orange);
            mBulletBrandTwo.setBackgroundColor(R.color.white);
            mBulletBrandThree.setBackgroundColor(R.color.white);
        }


    }

    public void previousImage(View view) {

        if (mCpt == 1){
            mImageBrand.setImageResource(R.mipmap.ic_office_work);
            mTextMarketBrand.setText(R.string.text_market_encardreur);
            mBulletBrandOne.setBackgroundColor(getResources().getColor(R.color.orange));
            mBulletBrandTwo.setBackgroundColor(getResources().getColor(R.color.white));
            mBulletBrandThree.setBackgroundColor(getResources().getColor(R.color.white));

        }else if(mCpt == 2){
            mImageBrand.setImageResource(R.mipmap.ic_commaunity);
            mBulletBrandOne.setBackgroundColor(getResources().getColor(R.color.white));
            mBulletBrandTwo.setBackgroundColor(getResources().getColor(R.color.orange));
            mTextMarketBrand.setText(R.string.text_market_forum);
        }else{
            mImageBrand.setImageResource(R.mipmap.ic_book);
            mBulletBrandTwo.setBackgroundColor(getResources().getColor(R.color.white));
            mBulletBrandThree.setBackgroundColor(getResources().getColor(R.color.orange));
            mTextMarketBrand.setText(R.string.text_market_contenu);

        }
    }
}