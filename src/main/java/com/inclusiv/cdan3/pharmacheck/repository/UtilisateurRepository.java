package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query(value = "SELECT id, adresse, email, mot_depasse, nom, prenom, statut_compte, telephonne FROM utilisateur WHERE email = :mail", nativeQuery = true)
    Utilisateur getUserByMail(@Param("mail") String mail);

    @Query(value = "SELECT COUNT(id_utilisateur) FROM public.utilisateur ", nativeQuery = true)
    long countUser();
}
