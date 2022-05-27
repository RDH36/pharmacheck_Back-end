package com.inclusiv.cdan3.pharmacheck.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Facture;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServiceFacture;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    ServiceFacture serviceFacture;
    @Autowired
    ServiceUtilisateur serviceUtilisateur;
    @Autowired
    StockRepository stockRepository;

    @PostMapping(path = "/add", consumes = "application/json")
    public Facture addFacture(@RequestBody Facture newFacture, HttpSession session){
        System.out.println(session.getAttribute("MAIL_USER"));
        Stock stock = stockRepository.getById(2L);
        Utilisateur utilisateur = serviceUtilisateur.getUserByMAIl((String) session.getAttribute("MAIL_USER"));
        newFacture.setUtilisateur(utilisateur);
        stock.getFacture().add(newFacture);
        return  serviceFacture.addFacture(newFacture);
    }

    @GetMapping("/list")
    public List<Facture> listFacture () {
        return  serviceFacture.listFacture();
    }
}
