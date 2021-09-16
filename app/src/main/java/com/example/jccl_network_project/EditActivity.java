package com.example.jccl_network_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jccl_network_project.adapters.General_adapter;
import com.example.jccl_network_project.custom_interface.OnviewHolderCallback;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity implements OnviewHolderCallback {

    List<Object> list;
    General_adapter adapter;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        recycler = findViewById(R.id.recycler_formation);

        list = new ArrayList<>();
        list.add(new Formation("bonjour"));
        list.add(new Formation("bonsoir"));
        list.add(new Formation("salut"));
        list.add(new Formation("yo"));
        list.add(new Formation("Hola"));
        adapter = new General_adapter(this, this , list ,R.layout.formation_item);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this ,RecyclerView.VERTICAL , false);
        recycler.setLayoutManager(lm);
        recycler.setAdapter(adapter);

    }

    @Override
    public void setFavorisViewInformation(int position) {
        EditText editText = findViewById(R.id.edit_formation);
        String edit = ((Formation) list.get(position)).getIntitule();
        editText.setText(edit);
    }

    @Override
    public List<View> getViews() {
        List<View> list = new ArrayList<>();
        View view = View.inflate(this , R.layout.formation_item,null);
        EditText edit = view.findViewById(R.id.edit_formation);
        Spinner spinner = view.findViewById(R.id.spinner_formation);
        list.add(edit);
        list.add(spinner);
        return list;
    }

    public class  Formation{
        private String intitule;

        public Formation(String intitule) {
            this.intitule = intitule;
        }

        public String getIntitule() {
            return intitule;
        }

        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }
    }
}