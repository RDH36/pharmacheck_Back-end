package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {

    //Récupère pharmacie par mail
    @Query(value = "SELECT id, adresse, email, etat_validation_compte, mot_de_passe, nif_pharamacie, nom_pharmacie, statit_pharmacie, telephonne FROM pharmacie WHERE email= :mail;", nativeQuery = true)
    Pharmacie getUserPharmacie(@Param("mail") String mail);

    //Recupère liste pharmacie non valide
    @Query(value = "SELECT id, adresse, email, etat_validation_compte, mot_de_passe, nom_pharmacie, statit_pharmacie, telephonne, nif_pharamacie, nif_pharmacie FROM pharmacie WHERE etat_validation_compte != 'Valide'", nativeQuery = true)
    List<Pharmacie> listPharmacieNonValide();

}
