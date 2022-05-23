package br.com.solary.dtos;

import br.com.solary.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

	private Long id;
	private String login;
	private String name;
	private String email;
	private String password;
	
	public UserRequestDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
	
}
