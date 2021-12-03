package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;

@RestController
@RequestMapping("/stock")
@Api(tags = "stock management")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class StockRestController {

	@Autowired
	StockService stockService;

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ApiOperation(value = "recuperer la liste des stocks")
	@ResponseBody
	public List<Stock> listStock() {
		return stockService.retrieveAllStocks();
	}

	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ApiOperation(value = "ajouter stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock c) {

		Stock stock = stockService.addStock(c);
		return stock;
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ApiOperation(value = "modifier stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

	// http://localhost:8089/SpringMVC/stock/retrieve-stock/1
	@GetMapping("/retrieve-stock/{stock-id}")
	@ApiOperation(value = "recuperer stock par id")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ApiOperation(value = "supprimer stock")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stocktId) {
		stockService.deleteStock(stocktId);
	}

	@GetMapping("/calcul-stock/{stock-id}")
	@ApiOperation(value = "calcul stock")
	@ResponseBody
	public void calculStock(@PathVariable("stock-id") Long stocktId) {
		stockService.calculStock(stocktId);
	}
	@GetMapping("/stock-rupture")
	@ApiOperation(value = "recuperer stock en rupture")
	@ResponseBody
	public List<Stock> retrieveStock() {
		return stockService.getStockEnRupture();
	}
	
	@GetMapping("/search-stock/{str}")
	@ApiOperation(value = "search by libelle")
	@ResponseBody
	public List<Stock> search(@PathVariable("str") String str) {
		return stockService.searchStcokWithLibelle(str);
	}
}
