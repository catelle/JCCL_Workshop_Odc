package com.example.jccl_network_project.models;

import java.util.Date;

public class Formation {

    private Date date;
    private String intitule;

    public Formation(Date date, String intitule) {
        this.date = date;
        this.intitule = intitule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
