package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    //Liste facture par pharmacie
    @Query (value = "SELECT facture.id, date_commande, etat_paiement, montant_facture, quantite_produit, validation_commande, stockid, utilisateurid FROM public.facture INNER JOIN public.stock ON facture.stockid=stock.id AND stock.pharmacieid=:idPharmacie ", nativeQuery = true)
    List<Facture> listeFactureparPharmacie(@Param("idPharmacie")long idPharmacie );

    List<Facture> findFacturesByValidationCommandeContainsIgnoreCaseOrderByUtilisateur(String validation);

    //Liste facture en attente par pharmacie
    @Query (value = "SELECT facture.id, facture.date_commande, facture.etat_paiement, facture.montant_facture, facture.quantite_produit, facture.validation_commande, facture.stockid, facture.utilisateurid\n" +
            "\tFROM public.facture INNER JOIN public.stock ON stock.pharmacieid=:idPharmacie AND facture.stockid=stock.id AND facture.validation_commande='attente'", nativeQuery = true)
    List<Facture> listeFactureEnAttenteParPharmacie(@Param("idPharmacie")long idPharmacie );

    //Liste facture valide par pharmacie
    @Query (value = "SELECT facture.id, date_commande, etat_paiement, montant_facture, quantite_produit, validation_commande, stockid, utilisateurid\n" +
            "\tFROM public.facture INNER JOIN public.stock ON stock.pharmacieid=:idPharmacie AND facture.stockid=stock.id AND validation_commande='Valide'", nativeQuery = true)
    List<Facture> listeFactureValideParPharmacie(@Param("idPharmacie")long idPharmacie );


    //Récupparation facture par id
    public Facture findFacturesByIdFacture(long idFacture);

    //Liste facture par paiement
    List<Facture> findFacturesByEtatPaiementContainsIgnoreCaseOrderByDateCommandeDesc(String paiement);


}
