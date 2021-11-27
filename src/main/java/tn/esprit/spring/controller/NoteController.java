package tn.esprit.spring.controller;

import java.util.Date;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Note;
import tn.esprit.spring.service.INote;

@RestController
@RequestMapping("/note")
public class NoteController {

	
	
	@Autowired
	INote NoteService;
	
	
	@PostMapping("/add-note/{id_produit}/{id_client}")
	@ResponseBody
	public void ajouterNote(@RequestBody Note n,@PathVariable("id_client") Long idclient,@PathVariable("id_produit") Long idProduit)
	{
		
		 NoteService.addNote(n, idProduit, idclient);
		
	}

	@GetMapping("/retrieve-all-notes-By-Clients/{id_client}")
	@ResponseBody
	public List<Note> getNoteByclient(@PathVariable("id_client") Long idclient){
		
		return NoteService.getNoteByClient1(idclient);
	}


	
	@GetMapping("/retrieve-all-notes-By-Clients-produits/{id_produit}/{id_client}")
	@ResponseBody
  	public List<Note> getNoteByProduitClient(@PathVariable("id_produit") Long idproduit,@PathVariable("id_client") Long idclient)
	{  
		return (List<Note>) NoteService.getNoteByProduitClient(idproduit,idclient);
	}	
	
	
	
	
	
	
	
	
	
}
