package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.reprpsetory.ClientReprositoey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceimpl implements ClientService{
    @Autowired //injection d'un objet
    ClientReprositoey agent; ///j'ai nomme l'objet
    @Override
    public void saveorupdate(Client c) {
        agent.save(c);

    }

    @Override
    public Client getById(long idc) {
        return (Client) agent.findById(idc).get();
    }

    @Override
    public void delete(long idc) {
        agent.deleteById(idc);

    }

    @Override
    public List<Client> consulte() {
        return (List<Client>) agent.findAll();
    }
}
