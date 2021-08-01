package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Client;

import java.util.List;

public interface ClientService {
    public void saveorupdate(Client c);
    public Client getById(long idc);
    public void delete(long idc);
    public List<Client> consulte();
}
