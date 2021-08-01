package com.funsoft.cabinet.service;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.reprpsetory.MedecinReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MedcinServiceImp implements MedcinService{
    @Autowired //injection d'un objet
    MedecinReprository agent; ///j'ai nomme l'objet
    @Override
    public void saveorupdate(Medecin m) {
        agent.save(m);

    }

    @Override
    public Medecin getById(long id) {
        return (Medecin) agent.findById(id).get();
    }

    @Override
    public void delete(long id) {
        agent.deleteById(id);

    }

    @Override
    public List<Medecin> consulte() {
        return (List<Medecin>) agent.findAll();
    }

    @Override
    public List<Medecin> recherche_specialite(String Spec) {
        return agent.findBySpecialite(Spec);
    }

    @Override
    public List<Medecin> recherche_specialite_nom(String Spec, String nom) {
        return agent.findBySpecialiteAndNom(Spec,nom);
    }

    @Override
    public List<Medecin> recherche_avancee(String Spec, String nom) {
        return agent.avanced_search(Spec,"%"+nom+"%");
    }
}

