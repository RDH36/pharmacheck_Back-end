package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRecherche {
    @Autowired
    PharmacieRepository pharmacieRepository;

    public List<Pharmacie> recherchePharmacie(String recherche){
        return pharmacieRepository.rechercheMulticriterePharmacie(recherche);
    }

    public List <Pharmacie> recherche(String recherche){
        //String [] tabRecherche= recherche.split(" ");
       /* List<Pharmacie> resulat = new ArrayList<>();
        for (int i=0; i<tabRecherche.length; i++){
            resulat.add((Pharmacie) pharmacieRepository.findPharmacieByAdresseContainsIgnoreCaseOrNomPharmacieContainsIgnoreCase(tabRecherche[i], tabRecherche[i]));
        }
*/

        return pharmacieRepository.findPharmacieByAdresseContainsIgnoreCaseOrNomPharmacieContainsIgnoreCase(recherche, recherche);

    }
}
