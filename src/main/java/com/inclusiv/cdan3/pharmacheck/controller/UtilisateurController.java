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

    @GetMapping("/list")
    public List<Utilisateur> list() {
        return  serviceUtilisateur.listUtilisateur();
    }

    @GetMapping("/user")
    public Utilisateur user (HttpSession session)  {
        return  serviceUtilisateur.getUserByMAIl((String) session.getAttribute("MAIL_USER"));
    }

    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idUtilisateur") long id) {
        serviceUtilisateur.deleteUtilisateurByID(id);
    }
}
