package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.TourDeGarde;
import com.inclusiv.cdan3.pharmacheck.service.ServiceTourDeGarde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/gardePharmacie")
public class TourGardeController {
    @Autowired
    ServiceTourDeGarde serviceTourDeGarde;

    @GetMapping("/listPharmacieDeGarde")
    public List<TourDeGarde> listeGarde(){
        return  serviceTourDeGarde.listeGarde();
    }

    @PostMapping(path = "/entreeGarde", consumes = "application/json")
    public TourDeGarde addTourDeGarde (@RequestBody TourDeGarde newTourDeGarde){

        return serviceTourDeGarde.addGarde(newTourDeGarde);
    }

}
