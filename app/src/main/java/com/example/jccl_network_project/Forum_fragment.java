package com.example.jccl_network_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jccl_network_project.detail_pages.FilDiscussionAdapter;
import com.example.jccl_network_project.detail_pages.WordCategoryAdapter;
import com.example.jccl_network_project.models.Fil_discussion;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Forum_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Forum_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<Fil_discussion> mForumList = new LinkedList<>();



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Forum_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment forum_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Forum_fragment newInstance(String param1, String param2) {
        Forum_fragment fragment = new Forum_fragment();
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
       View view= inflater.inflate(R.layout.fragment_forum_fragment, container, false);

        mWordList.addLast("Tous");
        mWordList.addLast("Cours");
        mWordList.addLast("Exercices");
        mWordList.addLast("Corrigés");


        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));
        mForumList.addLast(new Fil_discussion("1", "12.22.2021", "je n'arrive " +
                "pas rendre mon site responsive, Comment faire ?", false, "HTML/CSS"
                ,R.mipmap.ic_profil_tech,"Mikey McKenney","25" ));


        RecyclerView recyclerViewWord = (RecyclerView) view.findViewById(R.id.recyclerview_word);
        WordCategoryAdapter wordAdapter = new WordCategoryAdapter(getActivity(), mWordList);
        recyclerViewWord.setAdapter(wordAdapter);
        recyclerViewWord.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));


//        RecyclerView recyclerViewDoc = findViewById(R.id.recyclerview_grid);
//        DocumentAdapter docAdapter = new DocumentAdapter(this, DocumentModel.getObjectList());
//        recyclerViewDoc.setAdapter(docAdapter);
//        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(this ,
//                LinearLayoutManager.VERTICAL, false);
//        recyclerViewDoc.setLayoutManager(linearLayoutDoc);

        RecyclerView recyclerViewFilDiscussion = (RecyclerView) view.findViewById(R.id.recyclerview_grid);
        FilDiscussionAdapter fdAdapter = new FilDiscussionAdapter(getActivity(), mForumList);
        recyclerViewFilDiscussion.setAdapter(fdAdapter);
        RecyclerView.LayoutManager linearLayoutDoc = new LinearLayoutManager(getActivity() ,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewFilDiscussion.setLayoutManager(linearLayoutDoc);




        return view;
    }
}