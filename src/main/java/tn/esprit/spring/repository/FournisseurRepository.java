package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Fournisseur;


@Repository 
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
	@Query("SELECT f FROM Fournisseur f WHERE f.dateNaissance between :d1 and :d2 ")
	List<Fournisseur> retrieveAllFournisseurs();
}
