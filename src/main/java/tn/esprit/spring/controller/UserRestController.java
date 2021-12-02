package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;

@Api(tags = "User management")
@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Récupérer la liste des utilisateurs")
	// http://localhost:8089/SpringMVC/user/retrieve-all-user
	@GetMapping("/retrieve-all-user")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public List<User> listUser() {
		return userService.retrieveAllUsers();
	}


	// http://localhost:8089/SpringMVC/user/retrieve-user/{user-id}
	@GetMapping("/retrieve-user/{user-id}")
	@ApiOperation(value = "Récupérer client par id")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long clientId) {
		return userService.retrieveUser(clientId);
	}

	// http://localhost:8089/SpringMVC/user/add-user
	@PostMapping("/add-user")
	@ApiOperation(value = "ajouter user")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public User addClient(@RequestBody User c) {
		User client = userService.addUser(c);
		return client;
	}

	// http://localhost:8089/SpringMVC/user/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ApiOperation(value = "supprimer client")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')") //TO SECURE //TO SECURE //TO SECURE
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		userService.deleteUser(clientId);
	}

	// http://localhost:8089/SpringMVC/user/modify-client
	@PutMapping("/modify-client")
	@ApiOperation(value = "modifier client")
	@PreAuthorize("hasRole('USER')")
	@ResponseBody
	public User modifyClient(@RequestBody User client) {
		return userService.updateUser(client);
	}

}
