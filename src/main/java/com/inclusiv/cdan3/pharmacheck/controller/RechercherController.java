package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.service.ServiceRecherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/search")
public class RechercherController {
    @Autowired
    ServiceRecherche serviceRecherche;

    //Recherche pharmacie
    @JsonIgnore
    @GetMapping("/pharmacie")
    public List<List<Pharmacie>> listPharmacie(@RequestParam(value = "recherche")String recherche){
        String [] search = recherche.split(" ");
        List<List<Pharmacie>> pharmacieList = new ArrayList<>();
        for(int i=0; i<search.length; i++){
            pharmacieList.add(serviceRecherche.recherchePharmacie(search[i]));
        }
        return pharmacieList;
    }

    //Recherche produit
    @JsonIgnore
    @GetMapping("/rechercheProduit")
    public List<List <Produit>> listProduit(@RequestParam(value = "recherche") String recherche){
        String [] search = recherche.split(" ");
        List<List<Produit>> produitlist = new ArrayList<>();
        for (int i=0; i<search.length; i++){
            produitlist.add(serviceRecherche.rechercheProduit(search[i]));
        }
        return produitlist;
    }
/*
    @JsonIgnore
    @GetMapping("/test")
    public List<Pharmacie>listpharmacie(@RequestParam(value = "recherche")String recherche){
        return serviceRecherche.testPharma(recherche);
    }

 */
}
