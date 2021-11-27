package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.enume.Profession;
import tn.esprit.spring.enume.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idClient;

	String nom;

	String prenom;

	@Temporal(TemporalType.DATE)
	Date dateNaissance;

	String email;

	String password;

	@Enumerated(EnumType.STRING)
	CategorieClient categorieClient;

	@Enumerated(EnumType.STRING)
	Profession profession;
	@Enumerated(EnumType.STRING)
	Role role;

	@JsonIgnore
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	Set<Facture> factureList;

	


	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + "]";
	}

}
