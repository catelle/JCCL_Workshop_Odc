package com.example.jccl_network_project.detail_pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.R;
import com.example.jccl_network_project.adapters.GeneralRecyclerAdapter;
import com.example.jccl_network_project.custom_interface.OnViewHolderCallback;
import com.example.jccl_network_project.models.Commentaire;

import java.util.ArrayList;
import java.util.List;

public class TestGeneralAdapter extends AppCompatActivity implements OnViewHolderCallback {

    private List<Object> listComment = new ArrayList<>();
    private RecyclerView recycler ;
    private GeneralRecyclerAdapter adapter ;

    //item view
    private TextView mCommentText ;
    private TextView mCommentDate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_general_adapter);

        listComment.add( new Commentaire("12-12-2021","6t723887237" , "tres beau doc" , "5" , "kjfeijf") );
        listComment.add( new Commentaire("03-12-2021","6t723887237" , "trop nulle" , "5" , "kjfeijf") );
        listComment.add( new Commentaire("01-12-2021","6t723887237" , "tres naze" , "5" , "kjfeijf") );
        listComment.add(new Commentaire("22-12-2021","6t723887237" , "trop chiant" , "5" , "kjfeijf") );
        listComment.add(new Commentaire("19-12-2021","6t723887237" , "j'ai adorer" , "5" , "kjfeijf") );
        listComment.add(new Commentaire("14-12-2021","6t723887237" , "j'ai adorer" , "5" , "kjfeijf") );

        recycler = findViewById(R.id.recycler_test);
        adapter = new GeneralRecyclerAdapter(this ,  this, listComment , R.layout.comment_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

    }

    @Override
    public void setItemInformation(Object object) {
          mCommentText.setText(((Commentaire)object).getTexte());
          mCommentDate.setText(((Commentaire)object).getDate_creation());
    }

    @Override
    public void OnItemClick(int position, View itemView) {
//        Log.d("***cliqued" , "element cliquer : " + position);
        Toast.makeText(this , "element cliquer : " + position , Toast.LENGTH_SHORT);

    }

    @Override
    public void bindItemView(View view) {
        mCommentDate = view.findViewById(R.id.text_comment_date);
        mCommentText = view.findViewById(R.id.text_comment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}