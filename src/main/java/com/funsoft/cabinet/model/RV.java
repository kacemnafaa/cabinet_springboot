package com.funsoft.cabinet.model;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="rv")
public class RV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jour;
    @JoinColumn(name="ID_Medecin",referencedColumnName ="id")
    @ManyToOne(optional = false)
    private Medecin medecin;

    @JoinColumn(name="ID_Client",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Client client;

    public RV() {
        this.medecin = medecin; // pour avoir l'espace memoire cleint.id
        this.client = client;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public long getId() {
        return id;
    }

    public String getJour() {
        return jour;
    }

    public Client getClient() {
        return client;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<RV> rdvs;

    public List<RV> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<RV> rdvs) {
        this.rdvs = rdvs;
    }
}
