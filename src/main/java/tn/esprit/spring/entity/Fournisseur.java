package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Fournisseur")
public class Fournisseur implements Serializable {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private long idFournisseur;
	@Column(name="code")
	private String code;
	@Column(name="libelle")
	private String libelle;
	@Column(name="type")
	private String type;
	@Column(name="Telephone")
	private String Telephone;
	
	public Fournisseur() {}
	
	public Fournisseur(long idFournisseur, String code, String libelle, String type, String telephone) {
		super();
		this.idFournisseur = idFournisseur;
		this.code = code;
		this.libelle = libelle;
		this.type = type;
		Telephone = telephone;
	}

	public long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	@Override
	public String toString() {
		return "Fournisseur [idFournisseur=" + idFournisseur + ", code=" + code + ", libelle=" + libelle + ", type="
				+ type + ", Telephone=" + Telephone + "]";
	}

	
}
