package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

	Stock findByLibelleStock(String s);
	
	@Query("SELECT s FROM Stock s WHERE s.qteMin >= s.qte")
	List<Stock> retrieveStock();
	
	
	@Query("SELECT s FROM Stock s WHERE (s.qteMin >= s.qte) AND (s.checked = FALSE)")
	List<Stock> retrieveStockEnRp();
	
	@Query("SELECT s FROM Stock s WHERE s.libelleStock LIKE %:str%")
	List<Stock> rechercheStcokWithLibelle(@Param("str") String strrr);
}
