package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.enume.CategorieClient;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByEmailContainingAndCategorieClientIs(String email,CategorieClient categorie,Pageable pageable);
	Page<User> findByEmailContaining(String email,Pageable pageable);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	void findByDateNaissanceGreaterThan(Date dateN);


	//Statistique interactions
	@Query(value="SELECT COUNT(f.noote),f.client.categorieClient FROM Note f GROUP BY f.client.categorieClient")
	List <Object[]> getNotesByCategorieClient();


//	Faites une requête permettant de sélectionner tous les clients nés entre
//	01/01/1995 et 31/12/1995 en SQL.
	@Query("SELECT c FROM User c WHERE c.dateNaissance BETWEEN :d1 and :d2 ")
	List<User> retrieveClientsByDateNaissance(@Param("d1") Date d1 , @Param("d2") Date d2);
	


}
