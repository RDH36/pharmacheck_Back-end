package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtilisateur {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> listUtilisateur () {
        return  utilisateurRepository.findAll();
    }

    public Utilisateur saveUtilisateur (Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public void deleteUtilisateurByID(long id) {
        utilisateurRepository.deleteById(id);
    }
}
