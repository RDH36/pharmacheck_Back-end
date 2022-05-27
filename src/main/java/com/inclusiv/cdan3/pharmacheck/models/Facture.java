package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Facture")
public class Facture implements Serializable {
	public Facture() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="FACTURE_IDFACTURE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="FACTURE_IDFACTURE_GENERATOR", strategy="native")	
	private long idFacture;
	
	@ManyToOne(targetEntity=Utilisateur.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UtilisateurID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKFacture815327"))	
	private Utilisateur utilisateur;
	
	@Column(name="DateCommande", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateCommande;
	
	@Column(name="QuantiteProduit", nullable=false, length=10)	
	private int quantiteProduit;
	
	@Column(name="EtatPaiement", nullable=true, length=255)	
	private String etatPaiement;
	
	@Column(name="MontantFacture", nullable=false)	
	private double montantFacture;

	@Column(name = "validationCommande", nullable = false, length =50)
	private String validationCommande;


	@ManyToOne(targetEntity=Stock.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value={ @JoinColumn(name="StockID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKFacture937902"))
	private Stock stock;
	
	private void setIdFacture(long value) {
		this.idFacture = value;
	}
	
	public long getIdFacture() {
		return idFacture;
	}
	
	public long getORMID() {
		return getIdFacture();
	}
	
	public void setDateCommande(java.util.Date value) {
		this.dateCommande = value;
	}
	
	public java.util.Date getDateCommande() {
		return dateCommande;
	}
	
	public void setQuantiteProduit(int value) {
		this.quantiteProduit = value;
	}
	
	public int getQuantiteProduit() {
		return quantiteProduit;
	}
	
	public void setEtatPaiement(String value) {
		this.etatPaiement = value;
	}
	
	public String getEtatPaiement() {
		return etatPaiement;
	}
	
	public void setMontantFacture(double value) {
		this.montantFacture = value;
	}
	
	public double getMontantFacture() {
		return montantFacture;
	}
	
	public void setUtilisateur(Utilisateur value) {
		this.utilisateur = value;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public String getValidationCommande() {
		return validationCommande;
	}

	public void setValidationCommande(String validationCommande) {
		this.validationCommande = validationCommande;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String toString() {
		return String.valueOf(getIdFacture());
	}
	
}
