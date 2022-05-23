package br.com.solary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solary.dtos.UserRequestDTO;
import br.com.solary.dtos.UserResponseDTO;
import br.com.solary.exceptions.BusinessException;
import br.com.solary.services.impl.IUserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping
	public UserResponseDTO save(@RequestBody UserRequestDTO userRequest) throws BusinessException {
		
		return this.service.save(userRequest);
	}

}
