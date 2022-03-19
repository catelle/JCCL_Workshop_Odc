package com.example.jccl_network_project.models;

import java.util.Date;

public class Commentaire {

    private String commentaire_id ;
    private String date_creation;
    private String commenteur_id ;
    private String texte;
    private String note;
    private String commenteurPhoto;

    public Commentaire(){

    }

    public Commentaire(String date_creation, String commenteur_id, String texte , String note , String commenteurPhoto) {
        this.commentaire_id = commentaire_id;
        this.date_creation = date_creation;
        this.commenteur_id = commenteur_id;
        this.texte = texte;
        this.note = note;
        this.commenteurPhoto =commenteurPhoto ;
    }

    public String getCommentaire_id() {
        return commentaire_id;
    }

    public void setCommentaire_id(String commentaire_id) {
        this.commentaire_id = commentaire_id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getCommenteur_id() {
        return commenteur_id;
    }

    public void setCommenteur_id(String user_id) {
        this.commenteur_id = user_id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCommenteurPhoto() {
        return commenteurPhoto;
    }

    public void setCommenteurPhoto(String commenteurPhoto) {
        this.commenteurPhoto = commenteurPhoto;
    }
}
