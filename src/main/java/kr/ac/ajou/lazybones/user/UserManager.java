package kr.ac.ajou.lazybones.user;

import kr.ac.ajou.lazybones.repos.entities.User;

public interface UserManager {
	User insert(String id, String name, String pwd);
	User findById(String id);
	int update(User u);
	int delete(User u);
}