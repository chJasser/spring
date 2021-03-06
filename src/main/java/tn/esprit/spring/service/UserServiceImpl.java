package tn.esprit.spring.service;


import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	FactureRepository factureRepository;



	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Page<User> findByEmailContaining(String email, Pageable pageable) {
		return userRepository.findByEmailContaining(email,pageable);
	}

	@Override
	public Page<User> findByEmailContainingAndCategorieClientContaining(String email, String categorie, Pageable pageable) {
		CategorieClient	cat = CategorieClient.valueOf(categorie) ;
		//return userRepository.findByEmailAndCategorie(cat,pageable);
		return userRepository.findByEmailContainingAndCategorieClientIs(email,cat,pageable);
	}

	@Override
	public Page<User> pageAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<Facture> getHistoriqueAchat(Long userId) {
		User user = this.userRepository.getById(userId);
		return this.factureRepository.getFactureByClientOrderByDateFactureDesc(user);
	}

	@Override
	public Map<CategorieClient,Long> getNotesByCategorieClient() {
		List<Object[]> result = this.userRepository.getNotesByCategorieClient();
		System.out.println(result.get(0));
		Map<CategorieClient,Long> map = null;

		if(result != null && !result.isEmpty()){
			map = new HashMap<CategorieClient,Long>();
			for (Object[] object : result) {
				map.put((CategorieClient) object[1], (Long) object[0]);
			}
		}
		return map;
	}

	@Override
	public boolean assignAdmin(Long id) {
		Role r = this.roleRepository.getRoleAdmin();
		User u = this.userRepository.getById(id);
		if (!( u.getRoles().contains(r))) {
		u.getRoles().add(r);
		this.userRepository.saveAndFlush(u);
		return true ;} else {
			return false ;
			}

	}
	@Override
	public boolean withholdAdmin(Long id) {
		Role r = this.roleRepository.getRoleAdmin();
		User u = this.userRepository.getById(id);
		if ( u.getRoles().contains(r)) {
			u.getRoles().remove(r);
			this.userRepository.saveAndFlush(u);
			return true ;} else
			{ return false; }

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
