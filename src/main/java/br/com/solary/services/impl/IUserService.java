package br.com.solary.services.impl;

import java.util.List;

import br.com.solary.dtos.UserRequestDTO;
import br.com.solary.dtos.UserResponseDTO;

public abstract interface IUserService {

	public UserResponseDTO save(UserRequestDTO request);
	
	public UserResponseDTO delete(Long id);
	
	public UserResponseDTO findById(Long id);
	
	public List<UserResponseDTO> findAll();
	
}
