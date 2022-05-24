package com.inclusiv.cdan3.pharmacheck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Table;

import javax.persistence.Column;

@Data
@ToString
@NoArgsConstructor
public class ListeStockPharmacie {

    private String nomCommercial;

    public ListeStockPharmacie(String nomCommercial, String dci, String presentation, String conditionnement, String classePharmaceutique, int quantiteDisponible, double prixDeVente) {
        this.nomCommercial = nomCommercial;
        this.dci = dci;
        this.presentation = presentation;
        this.conditionnement = conditionnement;
        this.classePharmaceutique = classePharmaceutique;
        this.quantiteDisponible = quantiteDisponible;
        this.prixDeVente = prixDeVente;
    }


    private String dci;


    private String presentation;


    private String conditionnement;

    private String classePharmaceutique;

    private int quantiteDisponible;

    private double prixDeVente;

}
