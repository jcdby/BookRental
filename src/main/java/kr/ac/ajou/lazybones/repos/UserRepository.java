package kr.ac.ajou.lazybones.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.ajou.lazybones.repos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	<S extends User> S save(User user);

	User findById(String id);

	void delete(User u);
}