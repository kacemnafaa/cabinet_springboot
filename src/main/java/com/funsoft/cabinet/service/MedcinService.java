package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Medecin;

import java.util.List;

public interface MedcinService {
    public void saveorupdate(Medecin m);

    public Medecin getById(long id);

    public void delete(long id);

    public List<Medecin> consulte();
    public List<Medecin> recherche_specialite(String Spec);
    public List<Medecin> recherche_specialite_nom(String Spec,String nom);
    public List<Medecin> recherche_avancee(String Spec,String nom);


}

