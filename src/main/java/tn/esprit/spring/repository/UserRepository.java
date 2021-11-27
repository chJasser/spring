package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.enume.Role;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	void findByDateNaissanceGreaterThan(Date dateN);
	
	
//	Faites une requête permettant de sélectionner tous les clients nés entre
//	01/01/1995 et 31/12/1995 en SQL.
	
	@Query("SELECT c FROM User c WHERE c.dateNaissance BETWEEN :d1 and :d2 ")
	List<User> retrieveClientsByDateNaissance(@Param("d1") Date d1 , @Param("d2") Date d2);
	
	
	@Query("SELECT c FROM User c WHERE c.role= :role ")
	List<User> retrieveClients(@Param("role") Role r);
	
	@Query("SELECT c FROM User c WHERE c.role=admin ")
	List<User> retrieveAdmin();


//	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '01/01/1995' and '31/12/1995'" ,
//			nativeQuery = true)
//	List<Client> retrieveClientsByDateNai();

}
