package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
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
        return  serviceProduit.listeProduit();
    }


    @PostMapping(path = "/add", consumes = "application/json")
    public Produit addProduit (@RequestBody Produit newProduit,@RequestParam String mail  ,  HttpServletRequest request) {
        Stock stock = new Stock();
        Pharmacie pharmacie = servicePharmacie.getUserPharmacieByMail(mail);
        stock.setProduit(newProduit);
        System.out.println(mail);
        stock.setPharmacie(pharmacie);
        newProduit.getStock().add(stock);
        return  serviceProduit.addProduit(newProduit);
    }

    @GetMapping("/produit")
    public Produit getProduitById(@RequestParam("id") long id) {
        return  serviceProduit.getProduitById(id);
    }
    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idProduit") long id) {
        serviceProduit.deleteProduitByID(id);
    }

    //Récupère les 4 derniers produits
    @GetMapping("/dernierproduit")
    public List<Produit> dernierProduit (@RequestParam(value = "idPharmacie")long idPharmacie){
        return serviceProduit.dernierProduit(idPharmacie);
    }

    @GetMapping("/listStock")
    public  List<Stock> listStock(){
        return serviceProduit.listStock();
    }


}
