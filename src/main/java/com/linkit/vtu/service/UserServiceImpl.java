package com.linkit.vtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkit.vtu.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public User findUser(String email, String pwd) {
		
		User user = userRepo.findByEmailAndPassword(email,pwd);
		
		if(user != null)
			return user;
		
		return null;
	}


	@Override
	public User addUser(User user) {
		
		User userReturned = userRepo.save(user);
		
		if(userReturned != null)
			return userReturned;
		
		return null;
	}

}
