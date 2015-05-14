package kr.ac.ajou.data;

public interface UserRepository {
	User save(User user);
	User findById(String id);
}
