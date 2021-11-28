package tn.esprit.spring.service;


import java.util.Date;

import java.util.List;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;

public interface UserService {

	

	User addUser(User c);

	void deleteUser(Long id);

	User updateUser(User c);

	User retrieveUser(Long id);
	List <User> getClientWithDate(Date d1 ,Date d2);

	List<User> retrieveAllUsers();
/*	List<User> retrieveAlladmins();
	List<User> retrieveAllClients();*/
}
