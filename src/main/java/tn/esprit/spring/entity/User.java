package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.enume.Profession;

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
	@Column
	String username;

	@Temporal(TemporalType.DATE)
	Date dateNaissance;

	String email;

	String password;

	@Enumerated(EnumType.STRING)
	CategorieClient categorieClient;

	@Enumerated(EnumType.STRING)
	Profession profession;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles",
	joinColumns = @JoinColumn(name="id_client"),
	inverseJoinColumns = @JoinColumn(name="id"))
	private Set<Role> roles = new HashSet<>();
	//@JoinColumn(name = "role_id", referencedColumnName = "id")
	//private Role role;

	@JsonIgnore
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	Set<Facture> factureList;

	
	public User(String nom,String prenom,String username,String email,String password){
		this.nom = nom;
		this.prenom =prenom ;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + "]";
	}

}
