package com.example.jccl_network_project.models;


import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class Publication {


    private String publication_id;
    private String poster_id;
    private String categorie;
    private String description;
    private String destination;
    private String domaine;
    private int duree;
    private ArrayList<Integer> note;
    private String emplacement_piece ;
    private String lien;
    private String titre;
    private String date_ajout ;
    private List<String> mot_cles;

    private String date_creation ;

    private String niveau_scolaire;
    private List<Commentaire> commentaires;

    public Publication(){
    }

    public Publication(String publication_id, String poster_id, String categorie, String description, String destination, int duree, ArrayList<Integer> note, String emplacement_piece, String lien, String titre, String date_creation, ArrayList<String> mot_cles, String niveau_scolaire, List<Commentaire> commentaires) {
        this.publication_id = publication_id;
        this.poster_id = poster_id;
        this.categorie = categorie;
        this.description = description;
        this.destination = destination;
        this.duree = duree;
        this.note = note;
        this.emplacement_piece = emplacement_piece;
        this.lien = lien;
        this.titre = titre;
        this.date_creation = date_creation;
        this.mot_cles = mot_cles;
        this.niveau_scolaire = niveau_scolaire;
        this.commentaires = commentaires;
    }

    public Publication(String publication_id, String categorie, String description, String destination,  String lien, String titre, List<String> mot_cles, String niveau_scolaire) {
        this.publication_id = publication_id;
        this.poster_id = null;
        this.categorie = categorie;
        this.description = description;
        this.destination = destination;
        this.duree = 0;
        this.domaine=domaine;
        this.note = null;
        this.emplacement_piece = null;
        this.date_ajout=null;
        this.lien = lien;
        this.titre = titre;
        this.mot_cles = mot_cles;
        this.niveau_scolaire = niveau_scolaire;
        this.commentaires = null;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(String poster_id) {
        this.poster_id = poster_id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public ArrayList<Integer> getNote() {
        return note;
    }

    public void setNote(ArrayList<Integer> note) {
        this.note = note;
    }

    public String getEmplacement_piece() {
        return emplacement_piece;
    }

    public void setEmplacement_piece(String emplacement_piece) {
        this.emplacement_piece = emplacement_piece;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public List<String> getMot_cles() {
        return mot_cles;
    }

    public void setMot_cles(ArrayList<String> mot_cles) {
        this.mot_cles = mot_cles;
    }

    public String getNiveau_scolaire() {
        return niveau_scolaire;
    }

    public void setNiveau_scolaire(String niveau_scolaire) {
        this.niveau_scolaire = niveau_scolaire;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
