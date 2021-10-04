package com.example.jccl_network_project.models;

import java.util.List;
import java.util.Map;

public class Utilisateur {

    private String id_user;
    private String id_classe_virtuelle;
    private String avatar;
    private String categorie;
    private String description_profil;
    private String nom;
    private String prenom;
    private String profession;
    private String telephone;
    private String email;
    private Boolean validation;
    private List<Fil_discussion> fil_discussion;
    private List<Formation> formation;
    private List<Publication> favoris;
    private List<Publication> publication;
    private List<DocumentsFournis> DocumentsFournis;



    //user constructor doesn't take id as a parameter

    //public Utilisateur(String id_classe_virtuelle, String avatar, String categorie, String description_profil, String nom, String prenom, String profession, int telephone, String email, Boolean validation, List<Fil_discussion> fil_discussion, List<Formation> formation, List<Publication> favoris, List<Publication> publication) {

    public Utilisateur(String id_user, String nom,String phone_number, String profession, String email,Boolean validation) {

        this.id_user = id_user;
        this.id_classe_virtuelle = null;
        this.avatar = null;
        this.categorie = null;
        this.description_profil = null;
        this.nom = nom;
        this.prenom = null;
        this.profession = profession;
        this.telephone = phone_number;
        this.email = email;
        this.validation = validation;
        this.fil_discussion =null;
        this.formation = null;
        this.favoris = null;
        this.publication = null;
        this.DocumentsFournis=null;
    }

    public Utilisateur(String id_user, String nom, String statut_utilisateur, String email, Boolean validation) {
    }


    public  List<DocumentsFournis>  get_documentsFournis() {
        return DocumentsFournis;
    }

    public void set_DocumentFournis(DocumentsFournis doc) {
        this.DocumentsFournis.add(doc);
    }


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_classe_virtuelle() {
        return id_classe_virtuelle;
    }

    public void setId_classe_virtuelle(String id_classe_virtuelle) {
        this.id_classe_virtuelle = id_classe_virtuelle;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription_profil() {
        return description_profil;
    }

    public void setDescription_profil(String description_profil) {
        this.description_profil = description_profil;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public List<Fil_discussion> getFil_discussion() {
        return fil_discussion;
    }

    public void setFil_discussion(List<Fil_discussion> fil_discussion) {
        this.fil_discussion = fil_discussion;
    }

    public List<Formation> getFormation() {
        return formation;
    }

    public void setFormation(List<Formation> formation) {
        this.formation = formation;
    }

    public List<Publication> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Publication> favoris) {
        this.favoris = favoris;
    }

    public List<Publication> getPublication() {
        return publication;
    }

    public void setPublication(List<Publication> publication) {
        this.publication = publication;
    }

}

