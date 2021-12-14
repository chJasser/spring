package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Entrepot")

public class Entrepot implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEntrepot")
	private long idEntrepot;
	@Column(name="LieuLivraison")
	private String LieuLivraison;
	@Column(name="DateLivraison")
	private String DateLivraison;
	@Column(name="TypeProduit")
	private String TypeProduit;
	public long getIdEntrepot() {
		return idEntrepot;
	}
	public void setIdEntrepot(long idEntrepot) {
		this.idEntrepot = idEntrepot;
	}
	public String getLieuLivraison() {
		return LieuLivraison;
	}
	public void setLieuLivraison(String lieuLivraison) {
		LieuLivraison = lieuLivraison;
	}
	public String getDateLivraison() {
		return DateLivraison;
	}
	public void setDateLivraison(String dateLivraison) {
		DateLivraison = dateLivraison;
	}
	public String getTypeProduit() {
		return TypeProduit;
	}
	public void setTypeProduit(String typeProduit) {
		TypeProduit = typeProduit;
	}
	@Override
	public String toString() {
		return "Entrepot [idEntrepot=" + idEntrepot + ", LieuLivraison=" + LieuLivraison + ", DateLivraison="
				+ DateLivraison + ", TypeProduit=" + TypeProduit + "]";
	}
	public Entrepot(long idEntrepot, String lieuLivraison, String dateLivraison, String typeProduit) {
		super();
		this.idEntrepot = idEntrepot;
		LieuLivraison = lieuLivraison;
		DateLivraison = dateLivraison;
		TypeProduit = typeProduit;
	}
	
}
