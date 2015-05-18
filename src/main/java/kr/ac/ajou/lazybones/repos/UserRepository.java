package kr.ac.ajou.lazybones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.ajou.lazybones.repos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	<U extends User> U save(User user);
	User findById(String id);
	void delete(User u);
}