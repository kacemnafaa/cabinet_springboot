package com.funsoft.cabinet.Controller;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.RV;
import com.funsoft.cabinet.reprpsetory.RvReprosotory;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.MedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
public class RdvController {
    @Autowired
    RvReprosotory agent;
    @Autowired
    ClientService clientService;
    @Autowired
    MedcinService medcinService;

    @RequestMapping(value = "/rdvs/add", method = RequestMethod.GET)
    public ModelAndView add_rdv() {
        RV rdv = new RV();
        List<Client> clients = clientService.consulte();
        List<Medecin> meds = medcinService.consulte();
        ModelAndView model = new ModelAndView();
        model.addObject("rdvForm", rdv);
        model.addObject("clients", clients);
        model.addObject("medecins", meds);
        model.setViewName("rdv");
        return model;

    }

    @RequestMapping(value = "/rdvs/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("rdvForm") RV rdv) {
        agent.save(rdv);
        //ModelAndView model = new ModelAndView("redirect:/rdvs/list");
        return (new ModelAndView("redirect:/rdvs/list"));
    }

    @RequestMapping(value = "/rdvs/list", method = RequestMethod.GET)
    public ModelAndView list_Rdv() {
        List<RV> rdv = (List<RV>) agent.findAll();//get data from database
        ModelAndView model = new ModelAndView();
        model.addObject("Rdvs", rdv);
        model.setViewName("mes_Rdvs");//indiquer le nom de page web à retourner
        return (model);
    }

    @RequestMapping(value = "/rdvs/delete/{idr}", method = RequestMethod.GET)
    public ModelAndView delete_Rdv(@PathVariable("idr") RV idr) {
        agent.delete(idr);
        return (new ModelAndView("redirect:/rdvs/list"));
    }

    @RequestMapping(value = "/rdvs/update/{idr}", method = RequestMethod.GET)
    public ModelAndView update_rdv(@PathVariable("idr") long idrdv) {
        List<Client> clients = clientService.consulte();
        List<Medecin> meds = medcinService.consulte();
        RV rdv=agent.findById(idrdv).get();
        ModelAndView model = new ModelAndView();
        model.addObject("rdvForm", rdv);
        model.addObject("clients", clients);
        model.addObject("medecins", meds);
        model.setViewName("Editrdv");
        return model;
    }
}