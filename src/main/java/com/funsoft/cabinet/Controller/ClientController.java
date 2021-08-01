package com.funsoft.cabinet.Controller;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.RV;
import com.funsoft.cabinet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@RestController //controleur géneration 2 : page web,texte xml,json (RestAPI)

//@Controller//controlleur MVC (page web)
public class ClientController {
    //localhost:8082/clinique
    @Autowired
    ClientService agent;
    /*@RequestMapping(value="/",method= RequestMethod.GET)
    public String hello(){
        return "it's your first spring boot application";
    }*/
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test(){
        Client c = new Client();
        c.setNom("farhat");
        c.setPrenom("Rayhen");
        agent.saveorupdate(c);
        return "Client ajouté";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model= new ModelAndView();
        model.setViewName("index");//indiquer le nom de page web
        return model;
    }
    @RequestMapping(value = "/clients/list",method = RequestMethod.GET)
    public ModelAndView list_clients(){
        List<Client> clients=agent.consulte();//get data from database
        ModelAndView model=new ModelAndView();
        model.addObject("clients",clients);
        model.setViewName("mes_clients");//indiquer le nom de page web à retourner
        return model;


    }
    @RequestMapping(value = "/clients/delete/{idc}",method = RequestMethod.GET)
    public ModelAndView delete_client(@PathVariable("idc") long idc){
        agent.delete(idc);
        return(new ModelAndView("redirect:/clients/list"));

    }
    @RequestMapping(value = "/clients/add",method = RequestMethod.GET)
    public ModelAndView from_client() {
        Client c = new Client();//le model
        ModelAndView model = new ModelAndView(); // création model
        model.addObject("clientForm", c);
        model.setViewName("client");
        return model;
    }
    @RequestMapping(value = "/clients/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("clientForm") Client client, BindingResult result){
        if(result.hasErrors()){
            return (new ModelAndView("client"));
        }
        else {
            agent.saveorupdate(client);
            return (new ModelAndView("redirect:/clients/list"));
        }
    }
    @RequestMapping(value ="/clients/update/{idc}", method=RequestMethod.GET)
    public ModelAndView update_client (@PathVariable("idc") long idclient){
        Client c= agent.getById(idclient);
        ModelAndView model= new ModelAndView();
        model.addObject("clentForm",c);
        model.setViewName("editclient");
        return model;

    }

}
