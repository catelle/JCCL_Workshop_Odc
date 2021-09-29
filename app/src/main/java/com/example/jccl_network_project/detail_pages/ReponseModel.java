package com.example.jccl_network_project.detail_pages;

public class ReponseModel {

    private int img_posted;
    private String name_posted;
    private String date_post;
    private String text_reponse;
    private int img_reponse;

    public int getImg_posted() {
        return img_posted;
    }

    public void setImg_posted(int img_posted) {
        this.img_posted = img_posted;
    }

    public String getName_posted() {
        return name_posted;
    }

    public void setName_posted(String name_posted) {
        this.name_posted = name_posted;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public String getText_reponse() {
        return text_reponse;
    }

    public void setText_reponse(String text_reponse) {
        this.text_reponse = text_reponse;
    }

    public int getImg_reponse() {
        return img_reponse;
    }

    public void setImg_reponse(int img_reponse) {
        this.img_reponse = img_reponse;
    }

    public ReponseModel(int img_posted, String name_posted, String date_post, String text_reponse, int img_reponse) {
        this.img_posted = img_posted;
        this.name_posted = name_posted;
        this.date_post = date_post;
        this.text_reponse = text_reponse;
        this.img_reponse = img_reponse;
    }
}
