package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.models.TourDeGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourDeGardeRepository extends JpaRepository<TourDeGarde, Long> {
    @Query(value = "SELECT id, adresse_pharmacie_garde, contact_pharmacie_garde, date_de_debut, date_de_fin, nom_pharmacie_garde, telephone_pharmacie_garde FROM public.tour_de_garde WHERE date_de_fin > NOW() AND date_de_fin < (SELECT NOW() +INTERVAL '+7 DAYS'); ", nativeQuery = true)
    List<TourDeGarde> listGarde();
}
