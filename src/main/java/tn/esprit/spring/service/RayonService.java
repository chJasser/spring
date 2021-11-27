package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Rayon;

public interface RayonService {

	Rayon addRayon(Rayon r);

	List <Rayon> retriveAll();
	void deleteRayon(Long id);

	Rayon retrieveRayon(Long id);
}
