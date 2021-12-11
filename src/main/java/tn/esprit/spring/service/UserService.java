package tn.esprit.spring.service;


import java.util.Date;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.enume.CategorieClient;

public interface UserService {



	User addUser(User c);

	void deleteUser(Long id);

	User updateUser(User c);

	User retrieveUser(Long id);
	List <User> getClientWithDate(Date d1 ,Date d2);

	List<User> retrieveAllUsers();
	Page<User> findByEmailContaining(String email, Pageable pageable);
	Page<User> findByEmailContainingAndCategorieClientContaining(String email, String categorie, Pageable pageable);
	Page<User> pageAll(Pageable pageable);

	boolean assignAdmin( Long id);
	boolean withholdAdmin(Long id) ;

/*	List<User> retrieveAlladmins();
	List<User> retrieveAllClients();*/
}
