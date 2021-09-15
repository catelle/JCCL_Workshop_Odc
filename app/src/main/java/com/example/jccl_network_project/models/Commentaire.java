package com.example.jccl_network_project.models;

import java.util.Date;

public class Commentaire {

    private String commentaire_id ;
    private Date date_creation;
    private String user_id ;
    private String texte;

    public Commentaire(String commentaire_id, Date date_creation, String user_id, String texte) {
        this.commentaire_id = commentaire_id;
        this.date_creation = date_creation;
        this.user_id = user_id;
        this.texte = texte;
    }

    public String getCommentaire_id() {
        return commentaire_id;
    }

    public void setCommentaire_id(String commentaire_id) {
        this.commentaire_id = commentaire_id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
