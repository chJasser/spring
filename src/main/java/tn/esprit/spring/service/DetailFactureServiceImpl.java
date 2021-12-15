package tn.esprit.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.repository.DetailFactureRepository;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {
	
	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public DetailFacture addDetailFacture(DetailFacture detailFacture) {
		// TODO Auto-generated method stub
		return detailFactureRepository.save(detailFacture);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return detailFactureRepository.getRevenuBrutProduit(idProduit, startDate, endDate);
	}

}
