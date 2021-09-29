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
    private int telephone;
    private String email;
    private Boolean validation;
    private List<Fil_discussion> fil_discussion;
    private List<Formation> formation;
    private List<Publication> favoris;
    private List<Publication> publication;
    private List<DocumentsFournis> documentsFournis;

// added Documents fournis to this constructor

    public Utilisateur(String id_user, String id_classe_virtuelle, String avatar, String categorie, String description_profil, String nom, String prenom, String profession, int telephone, String email, Boolean validation, List<Fil_discussion> fil_discussion, List<Formation> formation, List<Publication> favoris, List<Publication> publication,List<DocumentsFournis> documentsFournis) {
        this.id_user = id_user;
        this.id_classe_virtuelle = id_classe_virtuelle;
        this.avatar = avatar;
        this.categorie = categorie;
        this.description_profil = description_profil;
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.telephone = telephone;
        this.email = email;
        this.validation = validation;
        this.fil_discussion = fil_discussion;
        this.formation = formation;
        this.favoris = favoris;
        this.publication = publication;
        this.documentsFournis=documentsFournis;
    }

    //constructor used for user registration

    public Utilisateur(String nom, String email,String status){
        this.nom=nom;
        this.email=email;
        this.profession=status;
        this.id_user = "ITTAE";
        this.id_classe_virtuelle = null;
        this.avatar = null;
        this.categorie = null;
        this.description_profil = null;

        this.prenom = null;

        this.telephone = 0;

        this.validation = null;
        this.fil_discussion = null;
        this.formation = null;
        this.favoris = null;
        this.publication = null;
        this.documentsFournis=null;

    }


    //add documents fournis getters and setters

    public void setDocumentsFournis(DocumentsFournis doc){
        this.documentsFournis.add(doc);

    }

    public List<DocumentsFournis> getDocumentFournis(){

        return this.documentsFournis;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
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
