package tn.esprit.spring.repository;





import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

	

	
//	@Query("SELECT  p FROM Produit p WHERE p.idProduit in :idPs")
//	List<Produit> retrieveProduitsByIdS(@Param("idPs") List<Long>
//	ids);
	
	
	@Query("SELECT  p.prixUnitaire FROM Produit p WHERE p.idProduit = :idP")
	float retrievePrixUnitaitreById(@Param("idP") Long id);
	
	@Query("SELECT  count(*) FROM Produit p WHERE p.stock.idStock = :idS")
	int calculStock(@Param("idS") Long id);
}
