package com.inclusiv.cdan3.pharmacheck.models;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Utilisateur")
public class Utilisateur implements Serializable {
	public Utilisateur() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="UTILISATEUR_IDUTILISATEUR_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="UTILISATEUR_IDUTILISATEUR_GENERATOR", strategy="native")	
	private long idUtilisateur;
	
	@Column(name="StatutCompte", nullable=true, length=255)	
	private String statutCompte;
	
	@Column(name="Nom", nullable=true, length=255)	
	private String nom;
	
	@Column(name="Prenom", nullable=true, length=255)	
	private String prenom;
	
	@Column(name="Adresse", nullable=true, length=255)	
	private String adresse;
	
	@Column(name="Telephonne", nullable=true, length=255)	
	private String telephonne;
	
	@Column(name="Email", nullable=true, length=255, unique = true)
	private String email;
	
	@Column(name="MotDepasse", nullable=true, length=255)	
	private String motDepasse;

	private void setIdUtilisateur(long value) {
		this.idUtilisateur = value;
	}
	
	public long getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public long getORMID() {
		return getIdUtilisateur();
	}
	
	public void setStatutCompte(String value) {
		this.statutCompte = value;
	}
	
	public String getStatutCompte() {
		return statutCompte;
	}
	
	public void setNom(String value) {
		this.nom = value;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenom(String value) {
		this.prenom = value;
	}
	
	public String getPrenom() {
		return prenom;
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
	
	public void setMotDepasse(String value) {
		this.motDepasse = value;
	}
	
	public String getMotDepasse() {
		return motDepasse;
	}
	
	public String toString() {
		return String.valueOf(getIdUtilisateur());
	}
	
}
