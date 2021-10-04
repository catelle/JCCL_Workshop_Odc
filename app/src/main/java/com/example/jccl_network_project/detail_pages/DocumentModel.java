package com.example.jccl_network_project.detail_pages;

import com.example.jccl_network_project.R;

import java.util.ArrayList;
import java.util.List;

public class DocumentModel {

    private  int img_profil_doc;
    private int img_profil_poster;
    private String name_poster;
    private String title_doc;
    private String description_doc;
    private String type_cours;
    private Boolean isFree;
    private  String note;

    public int getImg_profil_doc() {
        return img_profil_doc;
    }

    public void setImg_profil_doc(int img_profil_doc) {
        this.img_profil_doc = img_profil_doc;
    }

    public int getImg_profil_poster() {
        return img_profil_poster;
    }

    public void setImg_profil_poster(int img_profil_poster) {
        this.img_profil_poster = img_profil_poster;
    }

    public String getName_poster() {
        return name_poster;
    }

    public void setName_poster(String name_poster) {
        this.name_poster = name_poster;
    }

    public String getTitle_doc() {
        return title_doc;
    }

    public void setTitle_doc(String title_doc) {
        this.title_doc = title_doc;
    }

    public String getDescription_doc() {
        return description_doc;
    }

    public void setDescription_doc(String description_doc) {
        this.description_doc = description_doc;
    }

    public String getType_cours() {
        return type_cours;
    }

    public void setType_cours(String type_cours) {
        this.type_cours = type_cours;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static List<DocumentModel> getObjectList(){
        List<DocumentModel> dataList = new ArrayList<>();
        int[] images_poster = getImagesPoster();
        int[] images_doc = getImagesDoc();

        for (int i = 0; i < images_doc.length - 1  ; i++) {
            DocumentModel doc = new DocumentModel();
            doc.setImg_profil_doc(images_doc[i]);
            doc.setImg_profil_poster(images_poster[i]);
            doc.setTitle_doc("document " + i);
            doc.setDescription_doc("Il faut se documenter pour reuissir dans la voie " + i);
            doc.setFree(true);
            doc.setNote("15");
            doc.setName_poster("Christian " + i);
            doc.setType_cours("cours");
            dataList.add(doc);
        }

        return dataList;
    }

    private static int[] getImagesPoster(){

        int[] imagesPoster = {
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

        return imagesPoster;

    }

    private static int[] getImagesDoc(){

        int[] imagesDoc = {
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
                R.mipmap.ic_livre_mathpc,
        };

        return imagesDoc;


    }

}
