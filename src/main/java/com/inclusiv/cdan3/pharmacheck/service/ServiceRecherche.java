package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import com.inclusiv.cdan3.pharmacheck.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRecherche {
    @Autowired
    PharmacieRepository pharmacieRepository;

    @Autowired
    ProduitRepository produitRepository;

    //Recherche pharmacie
    public List <Pharmacie> recherchePharmacie(String recherche){
        return pharmacieRepository.findPharmacieByAdresseContainsIgnoreCaseOrNomPharmacieContainsIgnoreCase(recherche, recherche);
    }

    //Recherche produit
    public List<Produit> rechercheProduit(String recherche){
        return produitRepository.findProduitByClassePharmaceutiqueContainsIgnoreCaseOrNomCommercialContainsIgnoreCaseOrDciContainsIgnoreCase(recherche, recherche, recherche);
    }
}
