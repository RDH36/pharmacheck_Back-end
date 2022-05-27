package com.inclusiv.cdan3.pharmacheck.repository;

import com.inclusiv.cdan3.pharmacheck.models.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Long> {

    /*@Query(
            "CREATE TRIGGER update_stock_on_approvisionnement " +
                    "AFTER INSERT ON approvisionement" +
                    "BEGIN" +
                    "INSERT INTO stock (id_produit, id_pharmacie, quantité_disponible, prix_de_vente)" +
                    "VALUES (new.id_produit, new.id_pharmacie, new.quantite_entrant, new.prix_de_vente)" +
                    "END"
    )*/
}
