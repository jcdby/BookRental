package kr.ac.ajou.lazybones.repos;
import kr.ac.ajou.lazybones.repos.entities.User;

public interface UserRepository {
	User save(User user);
	User findById(String id);
}