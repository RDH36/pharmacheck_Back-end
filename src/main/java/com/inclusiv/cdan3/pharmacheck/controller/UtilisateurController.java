package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Facture;
import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceFacture;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @GetMapping("/listeInscrit")
    public List<Utilisateur> list() {
        return  serviceUtilisateur.listUtilisateur();
    }

    @DeleteMapping("/delete")
    public  String delete (HttpSession session) {
        serviceUtilisateur.deleteUtilisateurByID((Long) session.getAttribute("ID_USER"));
        return "delete";
    }



}
