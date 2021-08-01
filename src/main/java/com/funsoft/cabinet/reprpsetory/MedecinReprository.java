package com.funsoft.cabinet.reprpsetory;

import com.funsoft.cabinet.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinReprository extends CrudRepository<Medecin,Long> {
    //select m from Medecin m where m.specialite=:Spec (prepared statment)
    public List<Medecin> findBySpecialite(String Spec);
    // select m from Medecin m where m.specialite=: spec and m.nom=nom
    public List<Medecin> findBySpecialiteAndNom(String Spec,String nom);
    @Query(value="select m from Medecin m where m.specialite=:spec and (m.nom LIKE :pseudo or m.prenom LIKE :pseudo)" )
    public List<Medecin>avanced_search(@Param("spec") String s ,@Param("pseudo") String p);
}
