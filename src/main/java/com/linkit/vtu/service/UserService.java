package com.linkit.vtu.service;

import org.springframework.stereotype.Service;

import com.linkit.vtu.entities.User;

@Service
public interface UserService {

	User findUser(String email,String pwd);
	
	User addUser(User user);
}
