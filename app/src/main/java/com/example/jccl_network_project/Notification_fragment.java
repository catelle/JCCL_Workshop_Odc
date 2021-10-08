package com.example.jccl_network_project;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jccl_network_project.adapters.GeneralRecyclerAdapter;
import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.models.Fil_discussion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notification_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notification_fragment extends Fragment implements OnViewHolderCallback {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<Fil_discussion> mForumList = new LinkedList<>();
    private List<Object> mCategory = new ArrayList<>();
    private List<Object> list = new ArrayList<>();
    RecyclerView mRecyclerViewWord;
    private final String REQUEST_CODE_ADAPTER_PROFIL = "profil";
    private final String REQUEST_CODE_ADAPTER_CATEGORY = "categorie";
    private final String REQUEST_CODE_ADAPTER_PUBLICATION = "publication";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GeneralRecyclerAdapter wordAdapter;

    /*Contenu*/
    GeneralRecyclerAdapter profilAdapter;
    GeneralRecyclerAdapter docAdapter;

    public Notification_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notification_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Notification_fragment newInstance(String param1, String param2) {
        Notification_fragment fragment = new Notification_fragment();
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
        View view=inflater.inflate(R.layout.fragment_notification_fragment, container, false);
        profilAdapter = new GeneralRecyclerAdapter(getActivity(), this, list, R.layout.teacher_item, REQUEST_CODE_ADAPTER_PROFIL);
        docAdapter = new GeneralRecyclerAdapter(getActivity(), this, list, R.layout.document_item, REQUEST_CODE_ADAPTER_PUBLICATION);
        wordAdapter = new GeneralRecyclerAdapter(getActivity(), this, mCategory, R.layout.word_category, REQUEST_CODE_ADAPTER_CATEGORY);

        return view;
    }

    @Override
    public void setItemInformation(Object object, @Nullable String request_code) {

    }

    @Override
    public void onItemClick(int position, @Nullable String request_code) {

    }

    @Override
    public void bindItemView(View view, @Nullable String request_code) {

    }
}