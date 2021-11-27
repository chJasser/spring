package tn.esprit.spring.service;


import java.util.Date;

import java.util.List;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.enume.Role;

public interface UserService {

	

	User addClient(User c);

	void deleteClient(Long id);

	User updateClient(User c);

	User retrieveClient(Long id);
	List <User> getClientWithDate(Date d1 ,Date d2);

	List<User> retrieveAlladmins();
	List<User> retrieveAllClients();
}
