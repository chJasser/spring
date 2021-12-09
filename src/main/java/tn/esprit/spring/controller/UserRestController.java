package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;

@Api(tags = "User management")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Récupérer la liste des utilisateurs")
	@GetMapping("/retrieve-all-user")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public List<User> listUser() {
		return userService.retrieveAllUsers();
	}

	@ApiOperation(value = "Pagination des utilisateurs")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/paginate/users")
	public ResponseEntity<Map<String, Object>> getAllTutorials(
			@RequestParam(required = false) String email,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size
	) {

		try {
			List<User> users = new ArrayList<User>();
			Pageable paging = PageRequest.of(page, size);

			Page<User> pageTuts;
			if (email == null)
				pageTuts = userService.pageAll(paging);
			else
				pageTuts = userService.findByEmailContaining(email, paging);

			users = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("users", users);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	@GetMapping("/retrieve-user/{user-id}")
	@ApiOperation(value = "Récupérer client par id")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") Long clientId) {
		return userService.retrieveUser(clientId);
	}

	// THIS IS NOT A SIGNUP
	@PostMapping("/add-user")
	@ApiOperation(value = "ajouter user")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public User addClient(@RequestBody User c) {
		User client = userService.addUser(c);
		return client;
	}


	@DeleteMapping("/remove-client/{client-id}")
	@ApiOperation(value = "supprimer client")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')") //TO SECURE //TO SECURE //TO SECURE
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		userService.deleteUser(clientId);
	}


	@PutMapping("/modify-client")
	@ApiOperation(value = "modifier client")
	@PreAuthorize("hasRole('USER')")
	@ResponseBody
	public User modifyClient(@RequestBody User client) {
		return userService.updateUser(client);
	}

	@PutMapping("/assign-admin")
	//@ApiOperation(value = "assigner admin")
	@PreAuthorize("hasRole('ADMIN')")
	//@ResponseBody
	public void assignAdmin(@RequestBody String id) {
		System.out.println("TRIGGERED WITH "+id);
		 userService.assignAdmin(Long.valueOf(id));
	}
}
