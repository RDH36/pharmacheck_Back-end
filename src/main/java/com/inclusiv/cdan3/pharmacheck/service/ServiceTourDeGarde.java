package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.TourDeGarde;
import com.inclusiv.cdan3.pharmacheck.repository.TourDeGardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTourDeGarde {
    @Autowired
    TourDeGardeRepository tourDeGardeRepository;

    public List<TourDeGarde> listeGarde(){
        return tourDeGardeRepository.listGarde();
    }

    public TourDeGarde addGarde(TourDeGarde tourDeGarde){
        return tourDeGardeRepository.save(tourDeGarde);
    }
}
