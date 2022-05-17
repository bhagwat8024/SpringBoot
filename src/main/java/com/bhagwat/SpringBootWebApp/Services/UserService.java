package com.bhagwat.SpringBootWebApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagwat.SpringBootWebApp.Model.User;
import com.bhagwat.SpringBootWebApp.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public boolean isExistUser(User user) {
		Optional<User> newUser = userRepository.findById(user.getUsername());
		if (newUser.isPresent()) {
			if (newUser.get().getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void saveUser(User user) {
		System.out.println(user.getUsername() + " " + user.getPassword());
		userRepository.save(user);
	}

}
