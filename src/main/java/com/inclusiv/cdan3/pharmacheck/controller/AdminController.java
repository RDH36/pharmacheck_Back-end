package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.repository.PharmacieRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ServicePharmacie servicePharmacie;

    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @Autowired
    PharmacieRepository pharmacieRepository;

    //Recupere la liste des pharmacie en attente
    @GetMapping("/listpharmacieenattente")
    public List<Pharmacie> listpharmacieenattente(){

        return servicePharmacie.listPharamacieNonValide();
    }
    @GetMapping("/listPharmacieValide")
    public List<Pharmacie> listpharmacievalide(){

        return servicePharmacie.listPharamacieValide();
    }

    //Validation de la pharmacie
    /*@PutMapping(path = "/validationPharmacie", consumes = "application/json")
    public void validationPharmacie (@RequestParam long id){
        Pharmacie  pharmacie;
        pharmacie.setEtatValidationCompte("Valide");
        servicePharmacie.savePharmacieAuth(pharmacie);
    }
*/
    @PutMapping("/updatepharma")
    public void validationPharmacie(@RequestParam long idPharmacie){
        servicePharmacie.validePharmaceie(idPharmacie);
    }
    @PutMapping("/blockpharma")
    public void blockPharmacie(@RequestParam long idPharmacie){
        servicePharmacie.blockPharmacie(idPharmacie);
    }
    @GetMapping("/countvalide")
    public long  countValide(){
       return servicePharmacie.countValide();
    }
    @GetMapping("/countnonvalide")
    public long  countNonValide(){
        return servicePharmacie.countNonValide();
    }

    @GetMapping("/countuser")
    public long  countUser(){
        return serviceUtilisateur.countUser();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pharmacie> updateTutorial(@PathVariable("idPharmacie") long id) {
        Optional<Pharmacie> pharmacieData = pharmacieRepository.findById(id);
        if (pharmacieData.isPresent()) {
            Pharmacie pharmacie = pharmacieData.get();
            pharmacie.getIdPharmacie();
            pharmacie.setNomPharmacie(pharmacie.getNomPharmacie());
            pharmacie.setNifPharamacie(pharmacie.getNifPharamacie());
            pharmacie.setStatitPharamacie(pharmacie.getStatitPharmacie());
            pharmacie.setEtatValidationCompte("Valide");
            pharmacie.setAdresse(pharmacie.getAdresse());
            pharmacie.setTelephonne(pharmacie.getStatitPharmacie());
            pharmacie.setEmail(pharmacie.getStatitPharmacie());
            pharmacie.setMotDePasse(pharmacie.getStatitPharmacie());
            return new ResponseEntity<>(pharmacieRepository.save(pharmacie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
