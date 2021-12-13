package tn.esprit.spring.entity;

import java.util.Date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchProduit {
	String query;
	Date dateDebut;
	Date dateFin;
	float prixUnitaire;
	//String CategoryProduit;
	//float  note;
		
}