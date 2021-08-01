package com.funsoft.cabinet.Controller;
import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Recherche;
import com.funsoft.cabinet.service.MedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController //controleur géneration 2 : page web,texte xml,json (RestAPI)

public class MedcinController {

    @Autowired
     MedcinService agent;

    @RequestMapping(value="/medecins/test",method = RequestMethod.GET)
    public String test_medcin(){
        Medecin m = new Medecin();
        m.setNom("Boughatass");
        m.setPrenom("Monsef");
        m.setSpecialite("Spec 2");
        agent.saveorupdate(m);
        return "Medcin ajouté";
    }

    @RequestMapping(value = "/medecins/list",method = RequestMethod.GET)
    public ModelAndView list_medecin(){
        List<Medecin> medecins=agent.consulte();//get data from database
        ModelAndView model=new ModelAndView();
        model.addObject("medecins",medecins);
        model.setViewName("mes_medecins");//indiquer le nom de page web à retourner
        return model;


    }
    @RequestMapping(value = "/medecins/delete/{idm}",method = RequestMethod.GET)
    public ModelAndView delete_client(@PathVariable("idm") long idm){
        agent.delete(idm);
        return(new ModelAndView("redirect:/medecins/list"));

    }
    @RequestMapping(value = "/medecins/add",method =RequestMethod.GET )
    public ModelAndView from_Medcin(){
        Medecin m = new Medecin();
        ModelAndView model=new ModelAndView();
        model.addObject("medcinForm",m);
        model.setViewName("Medcins");
        return model;
    }
    @RequestMapping(value = "/medecins/save",method = RequestMethod.POST)
    public ModelAndView save(Medecin medecin){
        //Medecin m = new Medecin();
            agent.saveorupdate(medecin);
            return (new ModelAndView("redirect:/medecins/list"));
    }


    @RequestMapping(value = "/medecins/spec",method =RequestMethod.GET )
    public ModelAndView recherche(){
        Recherche res=new Recherche();//le model
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_spec");
        return model;
    }
    @RequestMapping(value = "/medecins/recherche",method = RequestMethod.POST)
    public ModelAndView recherche_spe(@ModelAttribute("resForm") Recherche res){
        List<Medecin> meds = agent.recherche_specialite(res.getSpecialite());
        res.setMedecins(meds);
        ModelAndView model =new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_spec");
        return model;
    }
    @RequestMapping(value = "/medecins/specnom",method =RequestMethod.GET )
    public ModelAndView recherche_specnom(){
        Recherche res=new Recherche();//le model
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_specnom");
        return model;
    }
    @RequestMapping(value = "/medecins/recherchespecnom",method = RequestMethod.POST)
    public ModelAndView recherche_spenom(@ModelAttribute("resForm") Recherche res){
        List<Medecin> meds = agent.recherche_specialite_nom(res.getSpecialite(),res.getNom());
        res.setMedecins(meds);
        ModelAndView model =new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_specnom");
        return model;
    }
    @RequestMapping(value = "/medecins/advanced",method =RequestMethod.GET )
    public ModelAndView recherche_advanced(){
        Recherche res=new Recherche();//le model
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_advanced");
        return model;
    }
    @RequestMapping(value = "/medecins/rechercheadvanced",method = RequestMethod.POST)
    public ModelAndView recherche_advanced(@ModelAttribute("resForm") Recherche res){
        List<Medecin> meds = agent.recherche_avancee(res.getSpecialite(),res.getNom());
        res.setMedecins(meds);
        ModelAndView model =new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("recherche_advanced");
        return model;
    }
    @RequestMapping(value ="/medecins/update/{idm}", method=RequestMethod.GET)
    public ModelAndView update_Medecin (@PathVariable("idm") long idcmedcin){
        Medecin m= agent.getById(idcmedcin);
        ModelAndView model= new ModelAndView();
        model.addObject("medecinForm",m);
        model.setViewName("editmedcin");
        return model;
    }
}
