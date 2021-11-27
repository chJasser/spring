package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit;

public interface ProduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);

	Produit assignProduitToStock(Long idProduit, Long idStock);

	Produit updateProduit(Produit p);

	void assignFournisseurToProduit(Long fournisseurId, Long produitId);

	float getPrixUnitaitreById(Long id);


}
