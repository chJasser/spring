package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;
@Service
public class RayonServiceImpl implements RayonService {

	
	@Autowired
	RayonRepository rayonRepository;
	
	
	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		r.setCreatedAt(new Date());
		return rayonRepository.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return rayonRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public List<Rayon> retriveAll() {
	return (List<Rayon>) rayonRepository.findAll();
		
	}
	
	@Override
	public Rayon updateRayon(Rayon r) {
		// TODO Auto-generated method stub
		r.setUpdatedAt(new Date());
		return rayonRepository.save(r);
	}


}
