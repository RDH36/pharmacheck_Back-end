package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
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

    @DeleteMapping("/delete")
    public void delete (long id ){
        servicePharmacie.deletePharmacieById(id);
    }

    @JsonIgnore
    @GetMapping("/listStock")
    public List<Stock> stockList (@RequestParam(value = "ID") long id){
        System.out.println(stockRepository.findStockByPharmacie_IdPharmacie(id));
        return  stockRepository.findStockByPharmacie_IdPharmacie(id);
    }


}
