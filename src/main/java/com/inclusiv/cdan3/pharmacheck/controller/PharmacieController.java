package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pharmacie")
public class PharmacieController {
    @Autowired
    ServicePharmacie servicePharmacie;
    @Autowired
    StockRepository stockRepository;

    @GetMapping("/listpharmacie")
    public List<Pharmacie> list(){
        return servicePharmacie.listPharmacie();
    }

    @PostMapping(path = "/addpharmacie", consumes = "application/json")
    public Pharmacie create(@RequestBody Pharmacie newPharmacie){
        Pharmacie pharmacie = servicePharmacie.savePharmacie(newPharmacie);
        return pharmacie;
    }

    @GetMapping("/deletepharmacie")
    public void delete (@RequestParam(value = "ID") long id  ){
        servicePharmacie.deletePharmacieById(id);
    }

    @JsonIgnore
    @GetMapping("/liste")
    public List<Stock> stockList (@RequestParam(value = "ID") long id){
        System.out.println(stockRepository.listestockpharmacie(id));
        return stockRepository.listestockpharmacie(id);
    }
}
