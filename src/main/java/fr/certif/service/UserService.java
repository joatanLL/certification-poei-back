package fr.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.certif.model.User;
import fr.certif.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository usr;

	public List<User> getAll() {

		return usr.findAll();
	}

	public void saveUser(User user) {

		usr.save(user);
	}

	public void deleteUser(Long id) {
		
		usr.deleteById(id);
		
	}

}
