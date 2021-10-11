package com.example.jccl_network_project.tab_home_page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.adapters.FavorisAdapter;
import com.example.jccl_network_project.models.ModelFavorisItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Favoris#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Favoris extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    //************* Declaration des variables *************//
    private List<ModelFavorisItem> list = new ArrayList<>();
    private RecyclerView recyclerFavoris;
    private View view;



    //********** End **************************///

    public Favoris() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Favoris.
     */
    // TODO: Rename and change types and number of parameters

    public static Favoris newInstance(String param1, String param2) {
        Favoris fragment = new Favoris();
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
        view = inflater.inflate(R.layout.fragment_favoris, container, false);

        this.list.add(new ModelFavorisItem("livre de cuisine" , "junior Temgoua" , "cours"));
        this.list.add(new ModelFavorisItem("livre de Math" , "Sonia Temgoua" , "Exercice"));
        this.list.add(new ModelFavorisItem("livre de Francais" , "Yvan Temgoua" , "Corriges"));


        // Mise en place du recycleView
        recyclerFavoris = view.findViewById(R.id.recycler_favoris);

        FavorisAdapter adapter = new FavorisAdapter(getContext() , this.list);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext() ,RecyclerView.VERTICAL , false);
        recyclerFavoris.setAdapter(adapter);
        recyclerFavoris.setLayoutManager(lm);

        return view;
    }
}