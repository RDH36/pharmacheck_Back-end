package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.dto.ListeStockPharmacie;
import com.inclusiv.cdan3.pharmacheck.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.JoinTable;
import javax.transaction.Transactional;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Modifying()
    @Transactional
    @Query(value = "UPDATE stock SET prix_de_vente= :prixDeVente, quantite_disponible=:quantiteDisponible WHERE pharmacieid=:pharmacieid AND produitid=:produitid", nativeQuery = true)
    void updateStock (@Param("prixDeVente") double prixVente, @Param("quantiteDisponible") int qte, @Param("pharmacieid") long idPharmacie,@Param("produitid") long idProduit);

    @Query(value = "SELECT quantite_disponible FROM stock WHERE pharmacieid=:pharmacieid AND produitid=:produitid", nativeQuery = true)
    int getQteStockProduit (@Param("pharmacieid") long idPharmacie,@Param("produitid") long idProduit);

    List<Stock> findStockByPharmacie_IdPharmacie (@Param("idpharmacie")long idpharmacie);
    @Modifying()
    @Transactional
    @Query(value = "UPDATE stock SET prix_de_vente= :prixDeVente, quantite_disponible=(SELECT quantite_disponible FROM stock  WHERE pharmacieid=:pharmacieid AND produitid=:produitid) + :quantiteCommande WHERE pharmacieid=:pharmacieid AND produitid=:produitid", nativeQuery = true)
    void updateStockFacture (@Param("prixDeVente") double prixVente, @Param("quantiteCommande") int qte, @Param("pharmacieid") long idPharmacie,@Param("produitid") long idProduit);

}
