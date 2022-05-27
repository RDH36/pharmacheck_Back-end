package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Facture;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.FactureRepository;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacture {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    FactureRepository factureRepository;

    public Facture addFacture (Facture facture){

        return factureRepository.save(facture);
    }
}
