package tn.esprit.spring.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enume.CategorieProduit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

	

	
//	@Query("SELECT  p FROM Produit p WHERE p.idProduit in :idPs")
//	List<Produit> retrieveProduitsByIdS(@Param("idPs") List<Long>
//	ids);
	
	
	@Query("SELECT  p.prixUnitaire FROM Produit p WHERE p.idProduit = :idP")
	float retrievePrixUnitaitreById(@Param("idP") Long id);
	
	@Query("SELECT  p FROM Produit p WHERE p.libelle LIKE %:libelle%")
	List<Produit> getProduitBylibelle(@Param("libelle") String libelle);
	
	
	@Query("SELECT  p FROM Produit p WHERE p.detailProduit.categorieProduit LIKE %:category%")
	List<Produit> getProduitBycategory(@Param("category") CategorieProduit category);
	

	
	
	
	/*
	@Query("SELECT  p FROM Produit p WHERE p.detailProduit = :category")
	List<Produit> getProduitByManycategory(@Param("category1") CategorieProduit category);
	*/
	@Query("SELECT  MIN(p) FROM Produit p ")
	Produit getMin();
	
	@Query("SELECT  MAX(p) FROM Produit p ")
	Produit getMax();
	
	@Query("SELECT  p FROM Produit p WHERE p.prixUnitaire<= :prixUnitaire1 ")
	List<Produit> getProduitByprixbetween(@Param("prixUnitaire1") float prixUnitaire1);
	
	@Query("SELECT  count(*) FROM Produit p WHERE p.stock.idStock = :idS")
	int calculStock(@Param("idS") Long id);

	
	@Query("SELECT  p FROM Produit p WHERE p.prixUnitaire<= :prixUnitaire1 and  p.detailProduit.categorieProduit = :category and p.libelle = :libelle")
	List<Produit> getByFiltre(@Param("category") CategorieProduit category,@Param("prix") float prix, @Param("libelle")String libelle);
}
