package com.linkit.vtu.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkit.vtu.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmailAndPassword(String email, String pwd);

}
