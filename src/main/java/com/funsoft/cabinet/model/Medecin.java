package com.funsoft.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medecins")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String specialite;

    public Medecin() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    @OneToMany(mappedBy = "medecin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RV> rdvs;

    public List<RV> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<RV> rdvs) {
        this.rdvs = rdvs;
    }
}
