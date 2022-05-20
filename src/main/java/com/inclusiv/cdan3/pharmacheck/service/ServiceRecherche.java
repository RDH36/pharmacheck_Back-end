package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceRecherche {
    @Autowired
    PharmacieRepository pharmacieRepository;

    public List<Pharmacie> recherchePharmacie(){
        return pharmacieRepository.rechercheMulticriterePharmacie();
    }

}
