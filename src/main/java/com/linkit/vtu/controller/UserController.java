package com.linkit.vtu.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.linkit.vtu.entities.User;
import com.linkit.vtu.service.UserService;

@RestController
public class UserController {

	private static final String gitToken = "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";
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(email);
		User user = new User();
		user.setEmail(email);
		user.setApiToken(token);
		user.setPassword(pwd);
		user.setGitToken(gitToken);
		User userReturned = userService.addUser(user);
		
		if(userReturned != null)
		   return userReturned;
		
		return new User();
		
	}
	
	@PostMapping("/getuser")
	public User getUser(@RequestBody User user) {
		
		
		String Email = user.getEmail() ;
		
		String Password = user.getPassword();
		
		System.out.println(Email+ "," + Password);
		
		User confirmedUser = userService.findUser(Email, Password);
		
		if(confirmedUser !=null)
			
			return confirmedUser ;
		
		return null;
	}
	
	private String getJWTToken(String email) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("linkitJWT")
				.setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
