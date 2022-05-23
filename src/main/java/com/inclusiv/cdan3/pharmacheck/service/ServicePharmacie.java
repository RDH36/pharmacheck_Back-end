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

    //Liste de toutes les pharmacies
    public List<Pharmacie> listPharmacie (){
        return  pharmacieRepository.findAll();
    }

    //Liste des pharmacies qui n'ont pas encore été validées
    public List<Pharmacie> listPharamacieNonValide(){
        return  pharmacieRepository.listPharmacieNonValide();
    }

    public List<Pharmacie> listPharamacieValide(){
        return  pharmacieRepository.listPharmacieValide();
    }

    //Récupération de la pharmacie par son email
    public Pharmacie getUserPharmacieByMail(String pharmacie){
        return pharmacieRepository.getUserPharmacie(pharmacie);
    }

    //Enregistre pharmacie
    public void savePharmacieAuth(Pharmacie pharmacie){
        pharmacieRepository.save(pharmacie);
    }

    //Efface pharmacie par son id
    public void deletePharmacieById(long id){
        pharmacieRepository.deleteById(id);
    }

    public List<Pharmacie> rechrchePharmacie(){
        return  pharmacieRepository.listPharmacieNonValide();
    }


    public void updatePharmacieById(long id, Pharmacie pharmacie) {
    public Pharmacie getById(Long id_phramacie) {
        return pharmacieRepository.getById(id_phramacie);
    }
}
