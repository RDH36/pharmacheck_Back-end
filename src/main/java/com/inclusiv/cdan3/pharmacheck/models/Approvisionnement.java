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

	@Column(name="idPharmacie", nullable=false)
	private long idPharmacie;

	@Column(name="prixDeVente", nullable=false)
	private double prixDeVente;
	@Column(name="idProduit", nullable=false)
	private long idProduit;
	@Column(name="DateDApprovisionnement", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDApprovisionnement;
	
	@Column(name="PrixDAchat", nullable=false)	
	private double prixDAchat;
	
	@Column(name="QuantiteEntrant", nullable=false, length=10)	
	private int quantiteEntrant;

	@Column(name="SeuilCritique", nullable=true, length=10)
	private long seuil;
	
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

	public void setSeuil(long value) {
		this.seuil = value;
	}

	public long getSeuil() {
		return seuil;
	}
	
	public void setDateDePeremption(java.util.Date value) {
		this.dateDePeremption = value;
	}
	
	public java.util.Date getDateDePeremption() {
		return dateDePeremption;
	}

	public long getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public double getPrixDeVente() {
		return prixDeVente;
	}

	public void setPrixDeVente(double prixDeVente) {
		this.prixDeVente = prixDeVente;
	}

	public String toString() {
		return String.valueOf(getIdApprovisionnement());
	}
	
}
