package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="TourDeGarde")
public class TourDeGarde implements Serializable {
	public TourDeGarde() {
	}
	
	@Column(name="ID", nullable=false)	
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
	
	@Column(name="PharmacieNonInscrit", nullable=true, length=255)	
	private String pharmacieNonInscrit;
	
	@ManyToMany(targetEntity=Pharmacie.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Pharmacie_TourDeGarde", joinColumns={ @JoinColumn(name="TourDeGardeID") }, inverseJoinColumns={ @JoinColumn(name="PharmacieID") })	
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
