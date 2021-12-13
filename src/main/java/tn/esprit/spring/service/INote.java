package tn.esprit.spring.service;

import java.util.List;


import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Note;


@Service
public interface INote {

	List<Note> retrieveAllNote();

	void addNote(Note n,Long idproduit,Long idClient);

	Note updateNote(Note n);
	
	Long AlreadyExists(Note n);

	Note retrieveNote(Long idNote);
	List<Note> getNoteByProduitClient(Long idproduit,Long idClient);

	
	List<Note> getNoteByClient1(Long idClient);
	
}
