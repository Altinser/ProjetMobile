package com.example.projetmobile;

public class Transaction {

    private String nom, type, montant;

    public Transaction(String nom, String type, String montant){
        this.nom = nom;
        this.type = type;
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getMontant() {
        return montant;
    }
}
