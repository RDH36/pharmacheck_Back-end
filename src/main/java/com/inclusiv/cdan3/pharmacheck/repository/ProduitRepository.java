package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.Root;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> searchAllByClassePharmaceutiqueContainsIgnoreCaseOrNomCommercialContainsIgnoreCaseOrDciContainsIgnoreCase(@Param("recherche") String rechercheClassePharmaceutique, @Param("recherche") String rechercheNomCommercial, @Param("recherche") String rechercheDci);

    @Query(value = "SELECT produit.id, nom_commercial, classe_pharmaceutique, conditionnement, dci, nom_commercial, presentation FROM public.produit INNER JOIN public.stock ON produit.id=stock.produitid AND stock.pharmacieid=:idPharmacie ORDER BY produit.id DESC LIMIT 4", nativeQuery = true)
    List<Produit> listdernierproduit(@Param("idPharmacie") long idPharmacie);

}


