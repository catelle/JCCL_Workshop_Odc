package com.example.jccl_network_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.jccl_network_project.adapters.Tab_fragment_Adapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profil_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profil_fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // ********************* Declarations variables **********************//
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    //variables used for profile edition

    Button mybutt;
    //********view componnents*****//

    TextView mlocalisationTV, nomTV, professionTV, villeTV;
    ImageView photo_profilIV,iconeditIV;


    //****String values containers//

    public static final String TAGlocalisation="localisation";
    public static final String TAGnom="nom";
    public static final String TAGprofession="profession";
    public static final String TAGville="ville";
    public static final String TAGphotoprofil="photo_profil";



    public Profil_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profil_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Profil_fragment newInstance(String param1, String param2) {
        Profil_fragment fragment = new Profil_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profil_fragment, container, false);
        tabLayout =  (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager2 = (ViewPager2) view.findViewById(R.id.viewpager2);
//        mybutt=view.findViewById(R.id.button_open_apercu);

        //liaison avec la vue

        mlocalisationTV=view.findViewById(R.id.localisation);
        professionTV=view.findViewById(R.id.profession);
        nomTV=view.findViewById(R.id.user_name);
        photo_profilIV=view.findViewById(R.id.user_picture);
        iconeditIV=view.findViewById(R.id.icon_edit);

//        mybutt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(),ViewProfileActivity.class));
//            }
//        });
        iconeditIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),EditActivity.class);
                intent.putExtra(TAGlocalisation,mlocalisationTV.getText().toString()
                );
                intent.putExtra(TAGprofession,professionTV.getText().toString());
                intent.putExtra(TAGnom, nomTV.getText().toString());

                startActivity(intent);

            }
        });

        FragmentManager fm = getActivity().getSupportFragmentManager();
        Tab_fragment_Adapter adapter = new Tab_fragment_Adapter(fm , getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Historique"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoris"));
        tabLayout.addTab(tabLayout.newTab().setText("Abonnees"));
        tabLayout.addTab(tabLayout.newTab().setText("A propos"));
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);
        return view ;
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