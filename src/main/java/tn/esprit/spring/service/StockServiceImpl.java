package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Autowired 
	ProduitRepository produitRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub

		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);

	}

	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void StockStatut() {
		// TODO Auto-generated method stub
		List<Stock> stockList;
		stockList = (List<Stock>) stockRepository.retrieveStock();
		for (Stock item : stockList) {
			log.info(item.getLibelleStock() + " en rupture la quantité min est "+item.getQteMin()+" la quant actuelle est "+item.getQte());
		}
	}

	@Transactional
	public void calculStock(Long idStock) {
		Stock s=retrieveStock(idStock);
		s.setQte(produitRepository.calculStock(idStock));
		 updateStock(s);
	}

}
