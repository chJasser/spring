package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Rayon;

import tn.esprit.spring.service.RayonService;


@RestController
@RequestMapping("/rayon")
@Api(tags = "rayon management")
public class RayonRestController {

	
	@Autowired
	RayonService rayonService;

	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ApiOperation(value = "Récupérer la liste des rayons")
	@ResponseBody
	public List<Rayon> listRayons() {
		return rayonService.retriveAll();
	}

	// http://localhost:8089/SpringMVC/rayon/add-rayon
	@PostMapping("/add-rayon")
	@ApiOperation(value = "ajouter rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r) {
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
	}

	

	// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/1
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ApiOperation(value = "Récupérer rayon par id")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
	}

	// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ApiOperation(value = "supprimer rayon")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
	}
	
}
