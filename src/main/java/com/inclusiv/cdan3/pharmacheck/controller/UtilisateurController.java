package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add", consumes = "application/json")
    public Utilisateur create(@RequestBody Utilisateur newUser) {
        Utilisateur user = serviceUtilisateur.saveUtilisateur(newUser);
        return  user;
    }

    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idUtilisateur") long id) {
        serviceUtilisateur.deleteUtilisateurByID(id);
    }
}
