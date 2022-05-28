package com.inclusiv.cdan3.pharmacheck.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inclusiv.cdan3.pharmacheck.models.Facture;
import com.inclusiv.cdan3.pharmacheck.models.Produit;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.repository.FactureRepository;
import com.inclusiv.cdan3.pharmacheck.repository.StockRepository;
import com.inclusiv.cdan3.pharmacheck.service.ServiceFacture;
import com.inclusiv.cdan3.pharmacheck.service.ServiceProduit;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import com.inclusiv.cdan3.pharmacheck.utilitaire.PDFGenerator;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    ServiceFacture serviceFacture;
    @Autowired
    ServiceProduit serviceProduit;
    @Autowired
    ServiceUtilisateur serviceUtilisateur;
    @Autowired
    StockRepository stockRepository;

    @Autowired
    FactureRepository factureRepository;

    @PostMapping(path = "/add", consumes = "application/json")
    public Facture addFacture(@RequestBody Facture newFacture, HttpSession session){
        System.out.println(session.getAttribute("MAIL_USER"));
        Stock stock = stockRepository.getById(2L);
        Utilisateur utilisateur = serviceUtilisateur.getUserByMAIl((String) session.getAttribute("MAIL_USER"));
        newFacture.setUtilisateur(utilisateur);
        newFacture.setValidationCommande("En attente de validation de commande");
        newFacture.setStock(stock);
        return  serviceFacture.addFacture(newFacture);
    }

    @JsonIgnore
    @GetMapping("/list")
    public List<Facture> listFacture () {
        System.out.println(serviceFacture.listFacture());
        return  serviceFacture.listFacture();
    }

    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response, @RequestParam("title") String title) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=" + title + ".pdf";
        response.setHeader(headerkey, headervalue);

        PDFGenerator generator = new PDFGenerator();
        generator.generate(response, title);
    }

    @GetMapping("/listFacturePharmacie")
    public List<Facture> listFacturePharmacie (@RequestParam("idPharmacie") long idPharmacie){
        return serviceFacture.listFactureParPharmacie(idPharmacie);
    }

    //Liste facture en attente
    @JsonIgnore
    @GetMapping("/listAttente")
    public List<Facture> listFactureEnattente (@RequestParam("idPharmacie") long idPharmacie) {
        return  serviceFacture.listFactureEnAttente(idPharmacie);
    }

    //Liste facture validée
    @GetMapping("/listFactureValide")
    public List<Facture> listFactureValid  (@RequestParam("idPharmacie") long idPharmacie){
        return serviceFacture.listFactureValideParPharmacie(idPharmacie);
    }

    //Valider une facture
    @PutMapping("/valideFacture")
    public void valideFacture (@RequestParam long idFacture){
        Facture facture;
        facture = factureRepository.findFacturesByIdFacture(idFacture);
        System.out.println(facture);
        facture.setValidationCommande("Validée");
        factureRepository.save(facture);
    }

    //Refuser une commande(facture)
    @PutMapping("/refusFacture")
    public void refusFacture (@RequestParam long idFacture){
        Facture facture;
        facture = factureRepository.findFacturesByIdFacture(idFacture);
        System.out.println(facture);
        facture.setValidationCommande("Refusée");
        factureRepository.save(facture);
    }

    //Liste facture impayé
    @JsonIgnore
    @GetMapping("/listFactureImpaye")
    public List<Facture> listFactureImpaye (String paiement) {
        paiement = "En attente";
        return  serviceFacture.listFactureParPaiement(paiement);
    }

    //Liste facture payé
    @GetMapping("/listFacturePaye")
    public List<Facture> listFacturePaye (String paiement){
        paiement = "Payée";
        return serviceFacture.listFactureParPaiement(paiement);
    }

    //Validation paiement
    @PutMapping("/validePaiement")
    public void validePaiement (@RequestParam long idFacture){
        Facture facture;
        facture = factureRepository.findFacturesByIdFacture(idFacture);
        System.out.println(facture);
        facture.setEtatPaiement("Payée");
        factureRepository.save(facture);
    }

}
