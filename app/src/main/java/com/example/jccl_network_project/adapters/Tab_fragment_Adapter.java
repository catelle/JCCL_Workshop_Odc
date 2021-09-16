package com.example.jccl_network_project.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.jccl_network_project.tab_home_page.A_propos;
import com.example.jccl_network_project.tab_home_page.Abonnee;
import com.example.jccl_network_project.tab_home_page.Favoris;
import com.example.jccl_network_project.tab_home_page.Historique;

public class Tab_fragment_Adapter extends FragmentStateAdapter {
    public Tab_fragment_Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch ((position)) {
            case 1 :
                return new Favoris();
            case 2 :
                return new Abonnee();
            case 3 :
                return new A_propos();

        }
        return new Historique();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
