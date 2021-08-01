package com.funsoft.cabinet.model;
import java.util.List;

public class Recherche {
    private String specialite;
    private List<Medecin> medecins;
    private String nom;

    public Recherche() {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
