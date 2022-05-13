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
@Table(name="TourDeGarde")
public class TourDeGarde implements Serializable {
	public TourDeGarde() {
	}
	
	@Column(name="IdGarde", nullable=false, length=19)	
	@Id	
	@GeneratedValue(generator="TOURDEGARDE_IDGARDE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="TOURDEGARDE_IDGARDE_GENERATOR", strategy="native")	
	private long idGarde;
	
	@Column(name="DateDeDebut", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDeDebut;
	
	@Column(name="DateDeFin", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dateDeFin;
	
	@Column(name="IDPharmacie", nullable=false, length=19)	
	private long iDPharmacie;
	
	@Column(name="PharmacieNonInscrit", nullable=true, length=255)	
	private String pharmacieNonInscrit;
	
	@ManyToMany(targetEntity=Pharmacie.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Utilisateur_TourDeGarde", joinColumns={ @JoinColumn(name="TourDeGardeIdGarde") }, inverseJoinColumns={ @JoinColumn(name="UtilisateurIdUtilisateur") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set pharmacie = new java.util.HashSet();
	
	private void setIdGarde(long value) {
		this.idGarde = value;
	}
	
	public long getIdGarde() {
		return idGarde;
	}
	
	public long getORMID() {
		return getIdGarde();
	}
	
	public void setDateDeDebut(java.util.Date value) {
		this.dateDeDebut = value;
	}
	
	public java.util.Date getDateDeDebut() {
		return dateDeDebut;
	}
	
	public void setDateDeFin(java.util.Date value) {
		this.dateDeFin = value;
	}
	
	public java.util.Date getDateDeFin() {
		return dateDeFin;
	}
	
	public void setiDPharmacie(long value) {
		this.iDPharmacie = value;
	}
	
	public long getiDPharmacie() {
		return iDPharmacie;
	}
	
	public void setPharmacieNonInscrit(String value) {
		this.pharmacieNonInscrit = value;
	}
	
	public String getPharmacieNonInscrit() {
		return pharmacieNonInscrit;
	}
	
	public void setPharmacie(java.util.Set value) {
		this.pharmacie = value;
	}
	
	public java.util.Set getPharmacie() {
		return pharmacie;
	}
	
	
	public String toString() {
		return String.valueOf(getIdGarde());
	}
	
}
