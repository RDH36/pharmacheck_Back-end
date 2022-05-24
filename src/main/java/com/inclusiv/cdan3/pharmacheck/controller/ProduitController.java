package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    ServiceProduit serviceProduit;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ServicePharmacie servicePharmacie;

    @GetMapping("/list")
    public List<Produit> produitList() {
        Stock stk = new Stock();
        stk.getProduit().getNomCommercial();
        return  serviceProduit.listeProduit();
    }


    @PostMapping(path = "/add", consumes = "application/json")
    public Produit addProduit (@RequestBody Produit newProduit, HttpSession session) {
        Stock stock = new Stock();
        Pharmacie pharmacie = servicePharmacie.getById((Long) session.getAttribute("ID_PHRAMACIE"));
        stock.setProduit(newProduit);
        stock.setPharmacie(pharmacie);
        newProduit.getStock().add(stock);

         return  serviceProduit.addProduit(newProduit);
    }

    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idProduit") long id) {
        serviceProduit.deleteProduitByID(id);
    }
}
