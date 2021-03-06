package br.com.solary.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solary.dtos.UserRequestDTO;
import br.com.solary.dtos.UserResponseDTO;
import br.com.solary.models.User;
import br.com.solary.repositories.UserRepository;
import br.com.solary.services.impl.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserResponseDTO save(UserRequestDTO request) {
		Optional<User> userOptional = repository.findByLogin(request.getLogin());
		
		if(userOptional.isPresent()) return null;
		
		User user = User.builder()
				.login(request.getLogin())
				.name(request.getName())
				.password(request.getPassword())
				.email(request.getEmail())
				.createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now()).build();
		
		this.repository.save(user);
		
		return new UserResponseDTO(user);
	}

	@Override
	public UserResponseDTO delete(Long id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) return null;
		
		this.repository.delete(user.get());
		
		return new UserResponseDTO(user.get());
	}

	@Override
	public UserResponseDTO findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) return null;
		
		return new UserResponseDTO(user.get());
	}

	@Override
	public List<UserResponseDTO> findAll() {
		return repository.findAll().stream().map(user -> new UserResponseDTO(user)).toList();
	}


}
