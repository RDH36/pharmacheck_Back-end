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
@RequestMapping("/pharmacie")
public class PharmacieController {
    @Autowired
    ServicePharmacie servicePharmacie;
    @Autowired
    StockRepository stockRepository;

    @GetMapping("/listPharmacie")
    public List<Pharmacie> list(){
        return servicePharmacie.listPharmacie();
    }
    

    @GetMapping("/pharmacie")
    public Pharmacie pharmacie(HttpSession session){
        Pharmacie pharmacie = servicePharmacie.getUserPharmacieByMail((String) session.getAttribute("MAIL_PHARMACIE"));
        session.setAttribute("ID_PHARMACIE", pharmacie.getIdPharmacie());
        return pharmacie;
    }

    @GetMapping("/deletepharmacie")
    public String delete (HttpSession session ){
        servicePharmacie.deletePharmacieById((long) session.getAttribute("ID_PHARMACIE"));
        return "delete";
    }

    @JsonIgnore
    @GetMapping("/listStock")
    public List<Stock> stockList (@RequestParam(value = "ID") long id){
        System.out.println(stockRepository.listestockpharmacie(id));
        return stockRepository.listestockpharmacie(id);
    }


}
