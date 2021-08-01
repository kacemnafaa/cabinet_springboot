package com.funsoft.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="clients") //pour renomer le tableau
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//auto-increment
    private long id;

    @Column(name ="nom_client")//pour modifier le nom de client au niveau de la table
    private String nom;
    @Size(min=3,max=10,message="la taille nom doit etre 3 et 10")
    @Pattern(regexp="[a-zA-Z]+",message="le nom ne doit que des alphabets")

    @Column(name ="prenom_client")//pour modifier le nom de client au niveau de la table

    private String prenom;
    @Size(min=3,max=10,message="la taille prenom doit etre 3 et 10")
    @Pattern(regexp="[a-zA-Z]+",message="le prenom ne doit que des alphabets")


    public Client() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RV> rdvs;

    public List<RV> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<RV> rdvs) {
        this.rdvs = rdvs;
    }
}
