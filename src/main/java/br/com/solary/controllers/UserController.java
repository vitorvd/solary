package br.com.solary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solary.dtos.UserRequestDTO;
import br.com.solary.dtos.UserResponseDTO;
import br.com.solary.services.impl.IUserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody UserRequestDTO userRequest) {
	
		UserResponseDTO user = this.service.save(userRequest);
		
		if(user == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("User %s is already in use, try another one.", userRequest.getLogin()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		
		UserResponseDTO user = this.service.findById(id);
		
		if(user == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(user);	
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		
		List<UserResponseDTO> users = this.service.findAll();
		
		if(users.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No one user saved yet.");
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(users);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
	
		UserResponseDTO user = this.service.delete(id);
		
		if(user == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		
		return ResponseEntity.status(HttpStatus.OK).body("User deleted.");
	}

}
