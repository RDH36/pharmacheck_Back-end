package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Pharmacie")
public class Pharmacie implements Serializable {
	public Pharmacie() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="PHARMACIE_IDPHARMACIE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PHARMACIE_IDPHARMACIE_GENERATOR", strategy="native")	
	private long idPharmacie;
	
	@Column(name="NomPharmacie", nullable=true, length=255)	
	private String nomPharmacie;
	
	@Column(name="NifPharmacie", nullable=true, length=255)
	private String nifPharamacie;
	
	@Column(name="StatitPharmacie", nullable=true, length=255)	
	private String statitPharmacie;
	
	@Column(name="EtatValidationCompte", nullable=true, length=255, columnDefinition = "En attente")
	private String etatValidationCompte;
	
	@Column(name="Adresse", nullable=true, length=255)	
	private String adresse;
	
	@Column(name="Telephonne", nullable=true, length=255)	
	private String telephonne;
	
	@Column(name="Email", nullable=true, length=255, unique = true)
	private String email;
	
	@Column(name="MotDePasse", nullable=true, length=255)	
	private String motDePasse;

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
	
	public void setStatitPharamacie(String value) {
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

	public String toString() {
		return String.valueOf(getIdPharmacie());
	}


}
