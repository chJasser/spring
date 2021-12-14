package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entrepot;
import tn.esprit.spring.entities.Fournisseur;


@Repository
public interface EntrepotRepository extends CrudRepository<Entrepot, Long> {
	@Query("SELECT e FROM Entrepot e WHERE e.Fournisseur = m ")
	List<Entrepot> getentrepotparfournisseur(@Param("m") Fournisseur m ); 

}
