package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Approvisionnement;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServiceApprovisionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        int qteStock = stockRepository.getQteStockProduit(newAppr.getIdPharmacie(), newAppr.getIdProduit());
        System.out.println("\n id "+newAppr.getIdPharmacie()+"\n le seuil est"+newAppr.getSeuil()+"\nentrant"+newAppr.getQuantiteEntrant()+"\nseuil"+newAppr.getSeuil());
        System.out.println(qteStock);
        stockRepository.updateStock(newAppr.getPrixDeVente(), (newAppr.getQuantiteEntrant() + qteStock), newAppr.getIdPharmacie(), newAppr.getIdProduit(), newAppr.getSeuil());
        return  serviceApprovisionnement.addApprovisionement(newAppr);
    }
}
