package com.example.projetmobile;

public class Utilisateur {
    private String nom;
    private String mdp;
    private String admin;

    public Utilisateur(String nom, String mdp, String admin) {
        this.nom = nom;
        this.mdp = mdp;
        this.admin = admin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
