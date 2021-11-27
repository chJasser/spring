package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@ApiOperation(value = "Récupérer la liste des clients")
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-user")
	@ResponseBody
	public List<User> listUser() {
		//Role r = new Role();
		return userService.retrieveAllClients();
	}

	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-user/{user-id}")
	@ApiOperation(value = "Récupérer client par id")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long clientId) {
		return userService.retrieveClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-user")
	@ApiOperation(value = "ajouter user")
	@ResponseBody
	public User addClient(@RequestBody User c) {
		User client = userService.addClient(c);
		return client;
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ApiOperation(value = "supprimer client")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		userService.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ApiOperation(value = "modifier client")
	@ResponseBody
	public User modifyClient(@RequestBody User client) {
		return userService.updateClient(client);
	}

}
