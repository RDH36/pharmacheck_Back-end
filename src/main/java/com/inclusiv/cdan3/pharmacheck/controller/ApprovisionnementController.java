package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Approvisionnement;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServiceApprovisionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    ServiceApprovisionnement serviceApprovisionnement;
    @Autowired
    StockRepository stockRepository;

    @GetMapping("/list")
    public List<Approvisionnement> getAllApprovisionement() {
        return  serviceApprovisionnement.getAllApprovisionement();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Approvisionnement addApprovisionement(@RequestBody Approvisionnement newAppr) {
        stockRepository.updateStock(newAppr.getPrixDeVente(), newAppr.getQuantiteEntrant(), newAppr.getIdPharmacie(), newAppr.getIdProduit());
        return  serviceApprovisionnement.addApprovisionement(newAppr);
    }
}
