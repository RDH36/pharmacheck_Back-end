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

    public List<Utilisateur> list () {
        return  utilisateurRepository.findAll();
    }

    public Utilisateur save (Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public void delete(long id) {
        utilisateurRepository.deleteById(id);
    }
}
