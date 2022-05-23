package br.com.solary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.solary.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT user FROM User user WHERE user.login = :login")
	Optional<User> findByLogin(String login);
	
}
