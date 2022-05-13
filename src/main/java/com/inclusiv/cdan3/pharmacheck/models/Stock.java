package com.inclusiv.cdan3.pharmacheck.models;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Stock")
public class Stock implements Serializable {
	public Stock() {
	}
	
	@Column(name="IdStock", nullable=false)	
	@Id	
	@GeneratedValue(generator="STOCK_IDSTOCK_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STOCK_IDSTOCK_GENERATOR", strategy="native")	
	private long idStock;
	
	@ManyToOne(targetEntity=Produit.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProduitIdProduit", referencedColumnName="IdProduit", nullable=false) }, foreignKey=@ForeignKey(name="FKStock905428"))	
	private Produit produit;
	
	@ManyToOne(targetEntity=Pharmacie.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PharmacieIdPharmacie", referencedColumnName="IdPharmacie", nullable=false) }, foreignKey=@ForeignKey(name="FKStock329268"))	
	private Pharmacie pharmacie;
	
	@Column(name="IdProduit", nullable=false)	
	private long idProduit;
	
	@Column(name="IdPharmacie", nullable=false)	
	private long idPharmacie;
	
	@Column(name="QuantitéDisponible", nullable=false, length=10)	
	private int quantitéDisponible;
	
	@Column(name="PrixDeVente", nullable=false)	
	private double prixDeVente;
	
	@ManyToMany(targetEntity=Facture.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Facture_Stock", joinColumns={ @JoinColumn(name="StockIdStock") }, inverseJoinColumns={ @JoinColumn(name="FactureIdFacture") })	
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
	
	public void setIdProduit(long value) {
		this.idProduit = value;
	}
	
	public long getIdProduit() {
		return idProduit;
	}
	
	public void setIdPharmacie(long value) {
		this.idPharmacie = value;
	}
	
	public long getIdPharmacie() {
		return idPharmacie;
	}
	
	public void setQuantitéDisponible(int value) {
		this.quantitéDisponible = value;
	}
	
	public int getQuantitéDisponible() {
		return quantitéDisponible;
	}
	
	public void setPrixDeVente(double value) {
		this.prixDeVente = value;
	}
	
	public double getPrixDeVente() {
		return prixDeVente;
	}
	
	public void setPharmacie(Pharmacie value) {
		this.pharmacie = value;
	}
	
	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	
	public void setProduit(Produit value) {
		this.produit = value;
	}
	
	public Produit getProduit() {
		return produit;
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
