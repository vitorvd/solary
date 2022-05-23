package br.com.solary.services.impl;

import java.util.List;

import br.com.solary.dtos.UserRequestDTO;
import br.com.solary.dtos.UserResponseDTO;
import br.com.solary.exceptions.BusinessException;

public abstract interface IUserService {

	public UserResponseDTO save(UserRequestDTO request) throws BusinessException;
	
	public UserResponseDTO delete(Long id);
	
	public UserResponseDTO findById(Long id);
	
	public List<UserResponseDTO> findAll();
	
	
}
