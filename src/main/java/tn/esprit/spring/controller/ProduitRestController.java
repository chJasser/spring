package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@Api(tags = "product management")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitService produitService;

	@ApiOperation(value = "ajouter produit")
	// http://localhost:8089/SpringMVC/produit/add-produit/3/1
	@PostMapping("/add-produit/{stock-id}/{rayon-id}")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p, @PathVariable("stock-id") Long sotckId,
			@PathVariable("rayon-id") Long rayonId) {

		return produitService.addProduit(p, sotckId, rayonId);
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ApiOperation(value = "Récupérer la liste des produit")
	@ResponseBody
	public List<Produit> listProduits() {
		return produitService.retrieveAllProduits();
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/1
	@GetMapping("/retrieve-produit/{produit-id}")
	@ApiOperation(value = "Récupérer produit par id")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	@PutMapping("/assignProduitToStock/{produit-id}/{stock-id}")
	@ApiOperation(value = "assign Produit To Stock")
	@ResponseBody
	public Produit assignProduitToStock(@PathVariable("produit-id") Long produitId,
			@PathVariable("stock-id") Long stockId) {
		return produitService.assignProduitToStock(produitId, stockId);
	}

	@ApiOperation("assing provider to product")
	@PutMapping("/assing-provider-to-product/{provider-id}/{product-id}")
	public void assignProviderToProduct(@PathVariable("provider-id") Long providerId,
			@PathVariable("product-id") Long productId) {
		this.produitService.assignFournisseurToProduit(providerId, productId);
	}

	
}
