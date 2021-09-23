package com.example.jccl_network_project.detail_pages;

import com.example.jccl_network_project.R;

import java.util.ArrayList;
import java.util.List;

public class ProfilModel {

    private  int img_profil;
    private String name;
    private String skill;

    public int getImg_profil() {
        return img_profil;
    }

    public void setImg_profil(int img_profil) {
        this.img_profil = img_profil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public static List<ProfilModel> getObjectList(){
        List<ProfilModel> dataList = new ArrayList<>();
        int[] images = getImages();

        for (int i = 0; i < images.length - 1 ; i++) {
            ProfilModel profil = new ProfilModel();
            profil.setImg_profil(images[i]);
            profil.setSkill("Mon metier " + i);
            profil.setName("Robert Tilda " + i);
            dataList.add(profil);
        }

        return dataList;
    }

    private static int[] getImages(){

        int[] images = {
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech,
                R.mipmap.ic_profil_tech
        };

        return images;

    }
}
