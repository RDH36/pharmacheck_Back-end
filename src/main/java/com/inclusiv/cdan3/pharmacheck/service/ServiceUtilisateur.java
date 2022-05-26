package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtilisateur {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> listUtilisateur () {
        return  utilisateurRepository.findAll();
    }

    public Utilisateur getUserByMAIl (String user) {
        return utilisateurRepository.getUserByMail(user);
    }

    public void saveUtilisateurWithAuth(Utilisateur user) {
        utilisateurRepository.save(user);
    }
    public long countUser(){
        return utilisateurRepository.countUser();
    }

    public void deleteUtilisateurByID(long id) {
        utilisateurRepository.deleteById(id);
    }
}
