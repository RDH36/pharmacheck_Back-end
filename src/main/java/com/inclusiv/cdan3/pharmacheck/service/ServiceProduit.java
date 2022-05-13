package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit {
    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> listeProduit() {
        return  produitRepository.findAll();
    }

    public Produit addProduit(Produit newProduit) {
        return  produitRepository.save(newProduit);
    }

    public void deleteUtilisateurByID(long id) {
        produitRepository.deleteById(id);
    }
}
