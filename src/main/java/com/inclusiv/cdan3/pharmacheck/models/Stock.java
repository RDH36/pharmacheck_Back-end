package com.inclusiv.cdan3.pharmacheck.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Stock")
public class Stock implements Serializable {
	public Stock() {
	}

	@Column(name="ID", nullable=false)
	@Id
	@GeneratedValue
	private long idStock;
	@JsonIgnore
	@ManyToOne(targetEntity=Produit.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns(value={ @JoinColumn(name="ProduitID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKStock253621"))
	private Produit produit;

	@ManyToOne(targetEntity=Pharmacie.class, fetch=FetchType.LAZY)
	@JoinColumns(value={ @JoinColumn(name="PharmacieID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKStock609654"))
	private Pharmacie pharmacie;

	@Column(name="QuantiteDisponible", nullable=false, length=10)
	private int quantiteDisponible;

	@Column(name="PrixDeVente", nullable=false)
	private double prixDeVente;

	@ManyToMany(targetEntity=Facture.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinTable(name="Facture_Stock", joinColumns={ @JoinColumn(name="StockID") }, inverseJoinColumns={ @JoinColumn(name="FactureID") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set facture = new java.util.HashSet();

	private void setIdStock(long value) {
		this.idStock = value;
	}

	public long getIdStock() {
		return idStock;
	}

	public long getORMID() {
		return getIdStock();
	}

	public void setQuantiteDisponible(int value) {
		this.quantiteDisponible = value;
	}

	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setPrixDeVente(double value) {
		this.prixDeVente = value;
	}

	public double getPrixDeVente() {
		return prixDeVente;
	}

	public void setProduit(Produit value) {
		this.produit = value;
	}


	public Produit getProduit() {
		return produit;
	}

	public void setPharmacie(Pharmacie value) {
		this.pharmacie = value;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	

	public void setFacture(java.util.Set value) {
		this.facture = value;
	}
	
	public java.util.Set getFacture() {
		return facture;
	}
	
	
	public String toString() {
		return String.valueOf(getIdStock());
	}
	
}
