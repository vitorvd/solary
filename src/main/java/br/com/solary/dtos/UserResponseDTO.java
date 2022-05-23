package br.com.solary.dtos;

import java.time.LocalDateTime;

import br.com.solary.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

	private Long id;
	private String login;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.name = user.getName();
		this.email = user.getEmail();
		this.createdAt = user.getCreatedAt();
		this.updatedAt = user.getUpdatedAt();
	}
	
}
