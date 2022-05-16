package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Approvisionnement")
public class Approvisionnement implements Serializable {
	public Approvisionnement() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="APPROVISIONNEMENT_IDAPPROVISIONNEMENT_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="APPROVISIONNEMENT_IDAPPROVISIONNEMENT_GENERATOR", strategy="native")	
	private long idApprovisionnement;
	
	@ManyToOne(targetEntity=Produit.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProduitID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKApprovisio373337"))	
	private Produit produit;
	
	@ManyToOne(targetEntity=Pharmacie.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PharmacieID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKApprovisio729370"))	
	private Pharmacie pharmacie;
	
	@Column(name="DateDApprovisionnement", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDApprovisionnement;
	
	@Column(name="PrixDAchat", nullable=false)	
	private double prixDAchat;
	
	@Column(name="QuantiteEntrant", nullable=false, length=10)	
	private int quantiteEntrant;
	
	@Column(name="DateDePeremption", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDePeremption;
	
	private void setIdApprovisionnement(long value) {
		this.idApprovisionnement = value;
	}
	
	public long getIdApprovisionnement() {
		return idApprovisionnement;
	}
	
	public long getORMID() {
		return getIdApprovisionnement();
	}
	
	public void setDateDApprovisionnement(java.util.Date value) {
		this.dateDApprovisionnement = value;
	}
	
	public java.util.Date getDateDApprovisionnement() {
		return dateDApprovisionnement;
	}
	
	public void setPrixDAchat(double value) {
		this.prixDAchat = value;
	}
	
	public double getPrixDAchat() {
		return prixDAchat;
	}
	
	public void setQuantiteEntrant(int value) {
		this.quantiteEntrant = value;
	}
	
	public int getQuantiteEntrant() {
		return quantiteEntrant;
	}
	
	public void setDateDePeremption(java.util.Date value) {
		this.dateDePeremption = value;
	}
	
	public java.util.Date getDateDePeremption() {
		return dateDePeremption;
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
	
	public String toString() {
		return String.valueOf(getIdApprovisionnement());
	}
	
}
