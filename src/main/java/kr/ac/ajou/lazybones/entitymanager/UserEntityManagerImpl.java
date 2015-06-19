package kr.ac.ajou.lazybones.entitymanager;

import kr.ac.ajou.lazybones.repos.UserRepository;
import kr.ac.ajou.lazybones.repos.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityManagerImpl implements UserEntityManager {

	@Autowired
	private UserRepository repo;

	@Override
	public User insert(String id, String name, String pwd) {
		User user = repo.save(new User(id, name, pwd));
		return user;
	}

	@Override
	public User findById(String id) {
		return repo.findById(id);
	}

	@Override
	public int update(User u) {
		if(repo.findById(u.getId()) != null){
			repo.save(u);
			return 1;
		} 
		return 0;
	}

	@Override
	public int delete(User u) {
		if(repo.findById(u.getId()) != null){
			repo.delete(u);
			return 1;
		} else {
			return 0;
		}
	}
}