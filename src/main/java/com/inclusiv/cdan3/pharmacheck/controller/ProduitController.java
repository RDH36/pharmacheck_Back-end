package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    ServiceProduit serviceProduit;

    @GetMapping("/list")
    public List<Produit> produitList() {
        return  serviceProduit.listeProduit();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Produit addProduit (@RequestBody Produit newProduit) {
        return serviceProduit.addProduit(newProduit);
    }

    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idProduit") long id) {
        serviceProduit.deleteUtilisateurByID(id);
    }
}
