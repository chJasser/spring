package tn.esprit.spring.service;

import java.util.Date;

import tn.esprit.spring.entity.DetailFacture;

public interface DetailFactureService {

	DetailFacture addDetailFacture(DetailFacture detailFacture );
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
