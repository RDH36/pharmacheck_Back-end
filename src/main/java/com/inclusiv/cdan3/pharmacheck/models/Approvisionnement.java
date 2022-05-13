package com.inclusiv.cdan3.pharmacheck.models; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Purchased
 */
import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Approvisionnement")
public class Approvisionnement implements Serializable {
	public Approvisionnement() {
	}
	
	@Column(name="IdApprovisionnement", nullable=false)	
	@Id	
	@GeneratedValue(generator="APPROVISIONNEMENT_IDAPPROVISIONNEMENT_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="APPROVISIONNEMENT_IDAPPROVISIONNEMENT_GENERATOR", strategy="native")	
	private long idApprovisionnement;
	
	@ManyToOne(targetEntity=Produit.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProduitIdProduit", referencedColumnName="IdProduit", nullable=false) }, foreignKey=@ForeignKey(name="FKApprovisio25145"))	
	private Produit produit;
	
	@ManyToOne(targetEntity=Pharmacie.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PharmacieIdPharmacie", referencedColumnName="IdPharmacie", nullable=false) }, foreignKey=@ForeignKey(name="FKApprovisio448984"))	
	private Pharmacie pharmacie;
	
	@Column(name="DateDApprovisionnement", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDApprovisionnement;
	
	@Column(name="IdPharmacie", nullable=false)	
	private long idPharmacie;
	
	@Column(name="IdProduit", nullable=false)	
	private long idProduit;
	
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
	
	public void setIdPharmacie(long value) {
		this.idPharmacie = value;
	}
	
	public long getIdPharmacie() {
		return idPharmacie;
	}
	
	public void setIdProduit(long value) {
		this.idProduit = value;
	}
	
	public long getIdProduit() {
		return idProduit;
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
