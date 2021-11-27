package tn.esprit.spring.service;


import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.enume.Role;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retrieveAllClients() {
		return (List<User>) userRepository.retrieveClients(Role.client);
	}
	
	@Override
	public List<User> retrieveAlladmins() {
		return (List<User>) userRepository.retrieveAdmin();
	}

	@Override
	public User addClient(User c) {
		c.setRole(Role.client);
		return userRepository.save(c);
		
	}
	

	@Override
	public void deleteClient(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public User updateClient(User c) {
		
		return userRepository.save(c);
	}

	@Override
	public User retrieveClient(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getClientWithDate(Date d1 ,Date d2) {
		// TODO Auto-generated method stub
		
		return userRepository.retrieveClientsByDateNaissance(d1,d2);

	//	return clientRepository.retrieveClientsByDateNaissance( new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1995"));
	}
	
	
	
		
	

}
