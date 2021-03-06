package com.inclusiv.cdan3.pharmacheck.controller;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin()
@RequestMapping("/authpharma")
public class AuthPharmacieController {
    @Autowired
    ServicePharmacie servicePharmacie;

    //Authentification à l'inscription
    @PostMapping(path = "/inscriptionpharma", consumes = "application/json")
    public Pharmacie inscriptionpharmacie(@RequestBody Pharmacie newPharmacie, HttpServletRequest request){
        String regexMail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String regexStatNif ="^[0-9]+$";
        Pattern patternMail = Pattern.compile(regexMail);
        Pattern patternStatNif = Pattern.compile(regexStatNif);

        Matcher matcher = patternMail.matcher(newPharmacie.getEmail());

        Matcher matcherNif= patternStatNif.matcher(newPharmacie.getNifPharamacie());
        Matcher matcherStatit = patternStatNif.matcher(newPharmacie.getStatitPharmacie());

        System.out.println(newPharmacie.getStatitPharmacie());
        System.out.println(newPharmacie.getNifPharamacie());

        if(matcher.matches() && matcherNif.matches() && matcherStatit.matches()){
            request.getSession().setAttribute("MAIL_PHARMACIE", newPharmacie.getEmail());
            newPharmacie.setEtatValidationCompte("En attente");
            servicePharmacie.savePharmacieAuth(newPharmacie);
        }
        return newPharmacie;
    }

    //Authentification à la connection
    @PostMapping(path = "/connectionpharmacie", consumes = "application/json")
    public Pharmacie connection (@RequestBody Pharmacie newPharmacie, HttpServletRequest request){
        Pharmacie pharmacie = servicePharmacie.getUserPharmacieByMail(newPharmacie.getEmail());
        //System.out.println(pharmacie.getMotDePasse() + " " + newPharmacie.getMotDePasse() + " " + pharmacie.getEmail() + " " + newPharmacie.getEmail());
        if (pharmacie.getMotDePasse().equals(newPharmacie.getMotDePasse()) && pharmacie.getEmail().equals(newPharmacie.getEmail())){
            request.getSession().setAttribute("MAIL_PHARMACIE", newPharmacie.getEmail());
            request.getSession().setAttribute("ID_PHARMACIE", pharmacie.getIdPharmacie());
        } else {
            pharmacie=new Pharmacie();
        }
        System.out.println(request.getSession().getAttribute("MAIL_PHARMACIE"));
        System.out.println("ID_PHARMACIE");
        return pharmacie;
    }
}
