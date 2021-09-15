package com.example.jccl_network_project.models;

public class Utilisateur {

    private String uid;
    private String nom;
    private String prenom;
    private String email;
    private String profession;
    private int telephone;


    public Utilisateur(String uid,String nom,String prenom, String email, String profession, int telephone){

        this.uid = uid;
        this.nom = nom;
        this.prenom = prenom;
        this.prenom = prenom;
        this.email = email;
        this.profession = profession;
        this.telephone =telephone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}

