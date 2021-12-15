package tn.esprit.spring.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.enume.CategorieProduit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	StockService stockService;

	@Autowired
	RayonService rayonService;

	@Autowired
	DetailProduitService detailProduitService;

	@Autowired
	FournisseurService fournisseurService;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepository.findAll();
	}

	@Transactional
	public Produit addProduit(Produit p, Long idStock, Long idRayon) {
		// TODO Auto-generated method stub
		System.out.println(p);
		p.setRayon(rayonService.retrieveRayon(idRayon));
		p.setStock(stockService.retrieveStock(idStock));
		p.setImage(p.getImage());
		DetailProduit d = detailProduitService.addDetailProduit(p);
		p.setDetailProduit(d);
		Produit product=produitRepository.save(p);
		stockService.calculStock(idStock);
		rayonService.calculQte(idRayon);
		return product;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public Produit updateProduit(Produit p,Long idProduit) {
		// TODO Auto-generated method stub
		DetailProduit d = detailProduitService.addDetailProduit(p);
		p.setDetailProduit(d);
		p.setIdProduit(idProduit);
		p.getDetailProduit().setDateDerniereModification(new Date());
		return produitRepository.save(p);
	}

	@Override
	public Produit assignProduitToStock(Long idProduit, Long idStock) {
		Stock s = stockService.retrieveStock(idStock);
		Produit p = retrieveProduit(idProduit);
		p.setStock(s);
		Produit product=updateProduit(p,idProduit);
		stockService.calculStock(idStock);
		return product;
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {

		Fournisseur f = fournisseurService.retriveFournisseur(fournisseurId);

		Produit p = this.retrieveProduit(produitId);
		Set<Fournisseur> mySet = new HashSet<Fournisseur>();
		mySet.add(f);
		p.setFournisseur(mySet);
		this.updateProduit(p,produitId);

	}

	@Transactional
	public float getPrixUnitaitreById(Long id) {
		// TODO Auto-generated method stub
		return this.produitRepository.retrievePrixUnitaitreById(id);
	}

	
	@Override
	public void deleteProduit(Long id) {
		this.produitRepository.deleteById(id);
		
	}
	
	@Override
	public List<Produit> getProduitByLibelle(String libelle) {
		return this.produitRepository.getProduitBylibelle(libelle);
		
	}

	@Override
	public List<Produit> getProduitBycategory(CategorieProduit category) {
		// TODO Auto-generated method stub
		return this.produitRepository.getProduitBycategory(category);
	}

	@Override
	public List<Produit> getProduitByprixbetween(float prixUnitaire1) {
		// TODO Auto-generated method stub
		return this.produitRepository.getProduitByprixbetween(prixUnitaire1);
	}

	@Override
	public List<Produit> getProduitByprixbetween(float prixUnitaire1, float prixUnitaire2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getMax() {
		// TODO Auto-generated method stub
		return this.produitRepository.getMax();
	}

	@Override
	public Produit getMin() {
		// TODO Auto-generated method stub
		return this.produitRepository.getMin();
	}
	
	
	@Override
	public List<Produit> getProduitByFiltre(CategorieProduit category,float prix,String libelle) {
		// TODO Auto-generated method stub
		return this.produitRepository.getByFiltre(category,prix,libelle);
	}

	
	
	
	@Override
	public List<Produit> getProductListNotAvInStock(Long stockId) {
		// TODO Auto-generated method stub
		return produitRepository.reteiveProductsNotAvInStcok(stockId);
	}
	
	@Override
	public List<Produit> getProductListNotAvInRayon(Long stockId) {
		// TODO Auto-generated method stub
		return produitRepository.reteiveProductsNotAvInRayon(stockId);
	}
	

	@Override
	public int getNbProductByStockAndCat(Long idStock, String cat) {
		// TODO Auto-generated method stub
		return produitRepository.getNbProductByStockAndCat(idStock, cat);
	}
	
	

	

}
