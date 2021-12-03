package tn.esprit.spring.service;


import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void assignAdmin(Long id) {
		Role r = this.roleRepository.getRoleAdmin();
		System.out.println("role "+ r.getName() + " retrieved ");
		User u = this.userRepository.getById(id);
		System.out.println(u.getEmail()+ "retrieved");
		if (!( u.getRoles().contains(r))) {
		u.getRoles().add(r); } else { System.out.println("ALREADY ADMIN"); }
		for(Role t : u.getRoles()){
			System.out.println("ROLES ARE :");
			System.out.println(t.getName());
	}
		this.userRepository.saveAndFlush(u);
	}

	@Override
	public User addUser(User c) {
	//c.setRole(Role.client);
		return userRepository.save(c);
	}
	

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public User updateUser(User c) {
		
		return userRepository.save(c);
	}

	@Override
	public User retrieveUser(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getClientWithDate(Date d1 ,Date d2) {
		// TODO Auto-generated method stub
		
		return userRepository.retrieveClientsByDateNaissance(d1,d2);

	//	return clientRepository.retrieveClientsByDateNaissance( new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1995"));
	}
	
	
	
		
	

}
