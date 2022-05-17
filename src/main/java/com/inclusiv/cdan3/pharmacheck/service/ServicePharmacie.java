package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import com.inclusiv.cdan3.pharmacheck.repository.ProduitRepository;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePharmacie {
    @Autowired
    PharmacieRepository pharmacieRepository;

    public List<Pharmacie> listPharmacie (){
        return  pharmacieRepository.findAll();
    }


    public Pharmacie getUserPharmacieByMail(String pharmacie){
        return pharmacieRepository.getUserPharmacie(pharmacie);
    }

    public void savePharmacieAuth(Pharmacie pharmacie){
        pharmacieRepository.save(pharmacie);
    }


    public void deletePharmacieById(long id){
        pharmacieRepository.deleteById(id);
    }



}
