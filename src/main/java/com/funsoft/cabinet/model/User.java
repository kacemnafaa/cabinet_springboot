package com.funsoft.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name ="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Employer employer;

    @JoinColumn(name="ID_Adresss",referencedColumnName = "id")
    @OneToOne(cascade =CascadeType.ALL)
    private Adress adress;

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
