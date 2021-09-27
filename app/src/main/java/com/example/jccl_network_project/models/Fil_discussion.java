package com.example.jccl_network_project.models;

import java.util.Date;
import java.util.List;

public class Fil_discussion {

    private String fil_id;
    private String date_creation;
    private String probleme;
    private String nb_commented;
    private Boolean status;
    private String titre;
    private String name_posted;
    private int img_poster;

    public int getImg_poster() {
        return img_poster;
    }

    public void setImg_poster(int img_poster) {
        this.img_poster = img_poster;
    }

    private List<Message> message;
    private List<String> mot_cles;

    public String getNb_commented() {
        return nb_commented;
    }

    public void setNb_commented(String nb_commented) {
        this.nb_commented = nb_commented;
    }

    public String getName_posted() {
        return name_posted;
    }

    public void setName_posted(String name_posted) {
        this.name_posted = name_posted;
    }

    public Fil_discussion(String fil_id, String date_creation, String probleme, Boolean status,
                          String titre, int img_poster,
                          String name_posted, String nb_commented) {
        this.fil_id = fil_id;
        this.date_creation = date_creation;
        this.probleme = probleme;
        this.status = status;
        this.titre = titre;
        this.message = message;
        this.mot_cles = mot_cles;
        this.name_posted = name_posted;
        this.img_poster = img_poster;
        this.nb_commented = nb_commented;
    }

    public String getFil_id() {
        return fil_id;
    }

    public void setFil_id(String fil_id) {
        this.fil_id = fil_id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<String> getMot_cles() {
        return mot_cles;
    }

    public void setMot_cles(List<String> mot_cles) {
        this.mot_cles = mot_cles;
    }
}
