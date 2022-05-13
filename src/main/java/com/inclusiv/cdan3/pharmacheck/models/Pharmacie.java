package  com.inclusiv.cdan3.pharmacheck.models;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Pharmacie")
public class Pharmacie extends Utilisateur implements Serializable {
	public Pharmacie() {
	}
	
	@Column(name="IdPharmacie", nullable=true, length=19)	
	private long idPharmacie;
	
	@Column(name="StatitPharmacie", nullable=true, length=255)	
	private String statitPharmacie;
	
	@Column(name="NifPharamacie", nullable=true, length=255)	
	private String nifPharamacie;
	
	@Column(name="NomPharmacie", nullable=true, length=255)	
	private String nomPharmacie;
	
	@Column(name="OrdrePharmacien", nullable=true, length=255)	
	private String ordrePharmacien;
	
	@Column(name="EtatValidationCompte", nullable=true, length=255)	
	private String etatValidationCompte;
	
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
	
	public void setIdPharmacie(long value) {
		this.idPharmacie = value;
	}
	
	public long getIdPharmacie() {
		return idPharmacie;
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
	
	public void setOrdrePharmacien(String value) {
		this.ordrePharmacien = value;
	}
	
	public String getOrdrePharmacien() {
		return ordrePharmacien;
	}
	
	public void setEtatValidationCompte(String value) {
		this.etatValidationCompte = value;
	}
	
	public String getEtatValidationCompte() {
		return etatValidationCompte;
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
		return super.toString();
	}
	
}
