package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pharmacie")
public class PharmacieController {
    @Autowired
    ServicePharmacie servicePharmacie;
    @Autowired
    StockRepository stockRepository;

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
    public List<Stock> stockList (HttpSession session){
        System.out.println(stockRepository.listestockpharmacie((Long) session.getAttribute("ID_PHARMACIE")));
        return stockRepository.listestockpharmacie((Long) session.getAttribute("ID_PHARMACIE"));
    }


}
