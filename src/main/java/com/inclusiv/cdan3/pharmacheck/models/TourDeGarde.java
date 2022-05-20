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
	
	@Column(name="nomPharmacieGarde", nullable=false, length=100)
	private String nomPharmacieGarde;

	@Column(name = "adressePharmacieGarde", nullable = false, length =100)
	private String adressePharmacieGarde;

	public String getNomPharmacieGarde() {
		return nomPharmacieGarde;
	}

	public void setNomPharmacieGarde(String nomPharmacieGarde) {
		this.nomPharmacieGarde = nomPharmacieGarde;
	}

	public String getAdressePharmacieGarde() {
		return adressePharmacieGarde;
	}

	public void setAdressePharmacieGarde(String adressePharmacieGarde) {
		this.adressePharmacieGarde = adressePharmacieGarde;
	}

	public String getTelephonePharmacieGarde() {
		return telephonePharmacieGarde;
	}

	public void setTelephonePharmacieGarde(String telephonePharmacieGarde) {
		this.telephonePharmacieGarde = telephonePharmacieGarde;
	}

	@Column(name = "contactPharmacieGarde", nullable = true, length = 20)
	private String contactPharmacieGarde;

	public String getContactPharmacieGarde() {
		return contactPharmacieGarde;
	}

	public void setContactPharmacieGarde(String contactPharmacieGarde) {
		this.contactPharmacieGarde = contactPharmacieGarde;
	}

	@Column(name = "telephonePharmacieGarde", nullable = true, length = 50)
	private String telephonePharmacieGarde;

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

	
	public String toString() {
		return String.valueOf(getIdGarde());
	}
	
}
