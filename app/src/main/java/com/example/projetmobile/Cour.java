package com.example.projetmobile;

import java.time.LocalDate;
import java.util.Date;

public class Cour {
    private String Professeur;
    private String Nom;
    private String Salle;
    private String Horraire;
    private LocalDate Date;

    public Cour(String professeur, String nom, String salle, String horraire, LocalDate date) {
        Professeur = professeur;
        Nom = nom;
        Salle = salle;
        Horraire = horraire;
        Date = date;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getProfesseur() {
        return Professeur;
    }

    public void setProfesseur(String professeur) {
        Professeur = professeur;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSalle() {
        return Salle;
    }

    public void setSalle(String salle) {
        Salle = salle;
    }

    public String getHorraire() {
        return Horraire;
    }

    public void setHorraire(String horraire) {
        Horraire = horraire;
    }
}
