package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @GetMapping("/listeInscrit")
    public List<Utilisateur> list() {
        return  serviceUtilisateur.listUtilisateur();
    }

    @GetMapping("/user")
    public Utilisateur user (HttpSession session)  {
        Utilisateur utilisateur = serviceUtilisateur.getUserByMAIl((String) session.getAttribute("MAIL_USER"));
        session.setAttribute("ID_USER", utilisateur.getIdUtilisateur());
        return  utilisateur;
    }

    @DeleteMapping("/delete")
    public  String delete (HttpSession session) {
        serviceUtilisateur.deleteUtilisateurByID((Long) session.getAttribute("ID_USER"));
        return "delete";
    }
}
