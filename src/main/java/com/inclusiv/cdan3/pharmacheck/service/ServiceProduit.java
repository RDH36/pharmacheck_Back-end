package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import com.inclusiv.cdan3.pharmacheck.repository.ProduitRepository;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduit {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    PharmacieRepository pharmacieRepository;

    @Autowired
    StockRepository stockRepository;

    public List<Produit> listeProduit() {
        return  produitRepository.findAll();
    }

    public Produit getProduitById(long id) {
        return  produitRepository.getById(id);
    }
    public Produit addProduit(Produit newProduit) {
        return  produitRepository.save(newProduit);
    }

    public void deleteProduitByID(long id) {
        produitRepository.deleteById(id);
    }

    public List <Produit> dernierProduit(long idPharmacie){
        return produitRepository.listdernierproduit(idPharmacie);
    }

}
