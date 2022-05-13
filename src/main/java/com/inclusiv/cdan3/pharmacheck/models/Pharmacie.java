package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Pharmacie")
public class Pharmacie implements Serializable {
	public Pharmacie() {
	}
	
	@Column(name="IdPharmacie", nullable=false)	
	@Id	
	@GeneratedValue(generator="PHARMACIE_IDPHARMACIE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PHARMACIE_IDPHARMACIE_GENERATOR", strategy="native")	
	private long idPharmacie;
	
	@Column(name="NomPharmacie", nullable=true, length=255)	
	private String nomPharmacie;
	
	@Column(name="NifPharamacie", nullable=true, length=255)	
	private String nifPharamacie;
	
	@Column(name="StatitPharmacie", nullable=true, length=255)	
	private String statitPharmacie;
	
	@Column(name="EtatValidationCompte", nullable=true, length=255)	
	private String etatValidationCompte;
	
	@Column(name="Adresse", nullable=true, length=255)	
	private String adresse;
	
	@Column(name="Telephonne", nullable=true, length=255)	
	private String telephonne;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="MotDePasse", nullable=true, length=255)	
	private String motDePasse;
	
	@ManyToMany(mappedBy="pharmacie", targetEntity=TourDeGarde.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set tourDeGarde = new java.util.HashSet();
	
	@OneToMany(mappedBy="pharmacie", targetEntity=Stock.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set stock = new java.util.HashSet();
	
	@OneToMany(mappedBy="pharmacie", targetEntity=Approvisionnement.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set approvisionnement = new java.util.HashSet();
	
	private void setIdPharmacie(long value) {
		this.idPharmacie = value;
	}
	
	public long getIdPharmacie() {
		return idPharmacie;
	}
	
	public long getORMID() {
		return getIdPharmacie();
	}
	
	public void setNomPharmacie(String value) {
		this.nomPharmacie = value;
	}
	
	public String getNomPharmacie() {
		return nomPharmacie;
	}
	
	public void setNifPharamacie(String value) {
		this.nifPharamacie = value;
	}
	
	public String getNifPharamacie() {
		return nifPharamacie;
	}
	
	public void setStatitPharmacie(String value) {
		this.statitPharmacie = value;
	}
	
	public String getStatitPharmacie() {
		return statitPharmacie;
	}
	
	public void setEtatValidationCompte(String value) {
		this.etatValidationCompte = value;
	}
	
	public String getEtatValidationCompte() {
		return etatValidationCompte;
	}
	
	public void setAdresse(String value) {
		this.adresse = value;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setTelephonne(String value) {
		this.telephonne = value;
	}
	
	public String getTelephonne() {
		return telephonne;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setMotDePasse(String value) {
		this.motDePasse = value;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setTourDeGarde(java.util.Set value) {
		this.tourDeGarde = value;
	}
	
	public java.util.Set getTourDeGarde() {
		return tourDeGarde;
	}
	
	
	public void setStock(java.util.Set value) {
		this.stock = value;
	}
	
	public java.util.Set getStock() {
		return stock;
	}
	
	
	public void setApprovisionnement(java.util.Set value) {
		this.approvisionnement = value;
	}
	
	public java.util.Set getApprovisionnement() {
		return approvisionnement;
	}
	
	
	public String toString() {
		return String.valueOf(getIdPharmacie());
	}
	
}
