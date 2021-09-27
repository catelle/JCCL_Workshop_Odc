package com.example.jccl_network_project.models;

public class ModelFavorisItem {
    private String title;
    private String posterName;
    private String categorie;

    public ModelFavorisItem(String title, String posterName, String categorie) {
        this.title = title;
        this.posterName = posterName;
        this.categorie = categorie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
