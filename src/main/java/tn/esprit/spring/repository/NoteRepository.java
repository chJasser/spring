package tn.esprit.spring.repository;

import java.util.Date;

import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.*;
import tn.esprit.spring.entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long>{

	
	
	@Transactional
    @Modifying
    @Query(value = "INSERT INTO note (coommentaire,date_note,noote,client_id_client,produit_id_produit) VALUES (:commentaire, :date, :note, :id_client, :id_produit)",nativeQuery = true)
	public void ajouterNote(@Param("note") Float Note,@Param("commentaire") String commentaire,@Param("date") Date dateNote,@Param("id_produit") Long idProduit, @Param("id_client")Long idClient);


	
	
	@Query("SELECT n FROM Note n WHERE n.client.idClient= :id_client")
	public List<Note> getNoteByclient(@Param("id_client") Long idClient);

	
	@Query("SELECT n FROM Note n WHERE n.produit.idProduit= :id_produit")
	public List<Note> getNoteByProduit(@Param("id_produit") Long idProduit);

	
  	@Query("SELECT n FROM Note n WHERE n.client.idClient= :id_client and  (n.produit.idProduit= :id_produit)")
  	public List<Note> getNoteByProduitClient(@Param("id_produit") Long idproduit,@Param("id_client") Long idClient);
  
  	@Query("SELECT n FROM Note n WHERE n.produit.NoteMoyenne= :note")
	public List<Note> getNoteBynoote(@Param("note") float note);

  	

}
