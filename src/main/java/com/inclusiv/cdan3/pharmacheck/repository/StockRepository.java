package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Modifying()
    @Transactional
    @Query(value = "UPDATE stock SET prix_de_vente= :prixDeVente, quantite_disponible=:quantiteDisponible WHERE pharmacieid=:pharmacieid AND produitid=:produitid", nativeQuery = true)
    void updateStock (@Param("prixDeVente") double prixVente,@Param("quantiteDisponible") int qte, @Param("pharmacieid")long idPharmacie,@Param("produitid") long idProduit);
}
