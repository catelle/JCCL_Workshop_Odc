package com.example.jccl_network_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jccl_network_project.VirtualClass.ClasseVirtuelleActivity;
import com.example.jccl_network_project.detail_pages.ProductActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.jccl_network_project.MainActivity.ELTTOSHOW;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Boolean isFabOpen=false;

    Button mAllStudentsButton, mAllTeachersButton,mAllpostsButton;
    FloatingActionButton mIntroVCButton;
    private FloatingActionButton mfabNewPost;

    public Home_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_fragment newInstance(String param1, String param2) {
        Home_fragment fragment = new Home_fragment();
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

        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        mAllpostsButton = (Button)view.findViewById(R.id.AllPublictions);
        mfabNewPost=view.findViewById(R.id.fabnewpost);
        mIntroVCButton = (FloatingActionButton)view.findViewById(R.id.fabCV);
        mAllStudentsButton = (Button)view.findViewById(R.id.AllStudentProfileButton);
        mAllTeachersButton = (Button)view.findViewById(R.id.AllTeachersProfilButton);
       FloatingActionButton mfabintro=(FloatingActionButton)view.findViewById(R.id.fabintro3);

       mfabintro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               translationfunction();

           }
       });


        mAllpostsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clic on allposts",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra(ELTTOSHOW,"publications");
                startActivity(intent);


            }
        });

        mIntroVCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ClasseVirtuelleActivity.class);

                startActivity(intent);


            }
        });

        mAllTeachersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clic on allteachers",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra(ELTTOSHOW,"enseignant");
                startActivity(intent);

            }
        });

        mAllStudentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clic on allstudents",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra(ELTTOSHOW,"etudiant");
                startActivity(intent);


            }
        });
        mAllpostsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clic on all posts",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra(ELTTOSHOW,"publication");
                startActivity(intent);


            }
        });


        return view;
    }

    public void translationfunction(){

        if(!isFabOpen){
            Toast.makeText(getActivity(),"fab1 clicked",Toast.LENGTH_LONG).show();
            isFabOpen=true;

            mfabNewPost.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
            mIntroVCButton.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
            // agendaFab.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
            //  fab1.setVisibility(View.INVISIBLE);
        }else{
            isFabOpen=false;
            mfabNewPost.animate().translationY(0);

            mIntroVCButton.animate().translationY(0);
            //  fab1.setVisibility(View.VISIBLE);
        }

    }

}