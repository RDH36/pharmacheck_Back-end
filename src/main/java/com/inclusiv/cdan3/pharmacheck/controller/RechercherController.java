package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServiceRecherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class RechercherController {
    @Autowired
    ServiceRecherche serviceRecherche;

    @GetMapping("/pharmacie")
    public List<Pharmacie> list(String recherche){
        System.out.println(recherche);
        System.out.println(serviceRecherche.recherchePharmacie(recherche));
        return serviceRecherche.recherchePharmacie(recherche);
    }

    @GetMapping("/test")
    public List<Pharmacie> listTest(String recherche){
        return serviceRecherche.recherche(recherche);
    }

    @GetMapping("/testPharma")
    public List<Pharmacie> listPharmacie(@RequestParam(value = "recherche")String recherche){
       /* System.out.println(recherche);
        String [] search = recherche.split(" ");
        List<List<Pharmacie>> pharmacieList = new ArrayList<>();
        for(int i=0; i<search.length; i++){
            pharmacieList.add(serviceRecherche.recherche(search[i]));
        }*/
        return serviceRecherche.recherche(recherche);
    }
}
