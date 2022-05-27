package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Facture;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServiceFacture;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/pharmacie")
public class PharmacieController {
    @Autowired
    ServicePharmacie servicePharmacie;
    @Autowired
    StockRepository stockRepository;

    @Autowired
    ServiceProduit serviceProduit;

    @Autowired
    ServiceFacture serviceFacture;

    //Renvoie la liste de toutes les pharmacies eenregistrées
    @GetMapping("/listPharmacie")
    public List<Pharmacie> list(){
        return servicePharmacie.listPharmacie();
    }



    //Session pharmacie
    @GetMapping("/pharmacie")
    public Pharmacie pharmacie(HttpSession session){
        Pharmacie pharmacie = servicePharmacie.getUserPharmacieByMail((String) session.getAttribute("MAIL_PHARMACIE"));
        session.setAttribute("ID_PHARMACIE", pharmacie.getIdPharmacie());
        return pharmacie;
    }

    //Efface pharmacie
    @GetMapping("/deletepharmacie")
    public String delete (HttpSession session ){
        servicePharmacie.deletePharmacieById((long) session.getAttribute("ID_PHARMACIE"));
        return "delete";
    }

    @JsonIgnore
    @GetMapping("/listStock")
    public List<Produit> stockList (@RequestParam(value = "ID") long id){
        List<Stock> listProduit = stockRepository.findStockByPharmacie_IdPharmacie(id);
        List<Produit> produitList = new ArrayList<>();
        for(int i = 0; i < listProduit.size(); i++) {
            produitList.add(listProduit.get(i).getProduit());
        }
        return produitList;
    }

    @GetMapping("/listFacture")
    public  List<Facture> factureList(){
        return serviceFacture.listFacture();
    }

}
