package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin()
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ServicePharmacie servicePharmacie;

    @Autowired
    PharmacieRepository pharmacieRepository;

    //Recupere la liste des pharmacie en attente
    @GetMapping("/listpharmacieenattente")
    public List<Pharmacie> listpharmacieenattente(){

        return servicePharmacie.listPharamacieNonValide();
    }

    //Validation de la pharmacie
    @PutMapping(path = "/validationPharmacie", consumes = "application/json")
    public void validationPharmacie (@RequestBody Pharmacie pharmacie){
            pharmacie.setEtatValidationCompte("Valide");
            servicePharmacie.savePharmacieAuth(pharmacie);
    }
}
