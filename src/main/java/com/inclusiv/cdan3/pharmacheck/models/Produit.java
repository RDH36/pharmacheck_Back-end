package com.inclusiv.cdan3.pharmacheck.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Produit")
public class Produit implements Serializable {
	public Produit() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="PRODUIT_IDPRODUIT_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PRODUIT_IDPRODUIT_GENERATOR", strategy="native")	
	private long idProduit;
	
	@Column(name="NomCommercial", nullable=true, length=255)	
	private String nomCommercial;
	
	@Column(name="Dci", nullable=true, length=255)	
	private String dci;
	
	@Column(name="Presentation", nullable=true, length=255)	
	private String presentation;
	
	@Column(name="Conditionnement", nullable=true, length=255)	
	private String conditionnement;

	@Column(name="ClassePharmaceutique", nullable=true, length=255)	
	private String classePharmaceutique;
	@OneToMany(mappedBy="produit", targetEntity=Stock.class, cascade = CascadeType.PERSIST)
	private java.util.Set<Stock> stock = new java.util.HashSet();


	
	private void setIdProduit(long value) {
		this.idProduit = value;
	}
	
	public long getIdProduit() {
		return idProduit;
	}
	
	public long getORMID() {
		return getIdProduit();
	}
	
	public void setNomCommercial(String value) {
		this.nomCommercial = value;
	}
	
	public String getNomCommercial() {
		return nomCommercial;
	}
	
	public void setDci(String value) {
		this.dci = value;
	}
	
	public String getDci() {
		return dci;
	}
	
	public void setPresentation(String value) {
		this.presentation = value;
	}
	
	public String getPresentation() {
		return presentation;
	}
	
	public void setConditionnement(String value) {
		this.conditionnement = value;
	}
	
	public String getConditionnement() {
		return conditionnement;
	}
	
	public void setClassePharmaceutique(String value) {
		this.classePharmaceutique = value;
	}
	
	public String getClassePharmaceutique() {
		return classePharmaceutique;
	}
	
	public void setStock(java.util.Set value) {
		this.stock = value;
	}
	
	public java.util.Set getStock() {
		return stock;
	}

	
	public String toString() {
		return String.valueOf(getIdProduit());
	}
	
}
