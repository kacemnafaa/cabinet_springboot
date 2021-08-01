package com.funsoft.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name="employees")

public class Employer {
    @Id
    @Column(name="user_id")
    private long id;
    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user ;
    private String specialite;

    public Employer() {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
