package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @GetMapping("/list")
    public List<Utilisateur> list() {
        return  serviceUtilisateur.list();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Utilisateur create(@RequestBody Utilisateur newUser) {
        Utilisateur user = serviceUtilisateur.save(newUser);
        return  user;
    }

    @GetMapping("/delete")
    public  void delete (@RequestParam(value = "idUtilisateur") long id) {
        serviceUtilisateur.delete(id);
    }
}
