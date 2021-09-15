package com.example.jccl_network_project.models;

import java.util.Date;
import java.util.List;

public class Fil_discussion {

    private String fil_id;
    private Date date_creation;
    private String probleme;
    private Boolean status;
    private String titre;
    private List<Message> message;
    private List<String> mot_cles;

    public Fil_discussion(String fil_id, Date date_creation, String probleme, Boolean status, String titre, List<Message> message, List<String> mot_cles) {
        this.fil_id = fil_id;
        this.date_creation = date_creation;
        this.probleme = probleme;
        this.status = status;
        this.titre = titre;
        this.message = message;
        this.mot_cles = mot_cles;
    }

    public String getFil_id() {
        return fil_id;
    }

    public void setFil_id(String fil_id) {
        this.fil_id = fil_id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
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
