package com.linkit.vtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.service.SchemeService;

@CrossOrigin
@Controller
public class SchemeController {
	
	@Autowired
	SchemeService schemeService;
	
	@PostMapping("/addscheme/{scheme}")
	ResponseEntity<HttpStatus> addScheme(@PathVariable("scheme") String year){
		Scheme scheme = new Scheme();
		scheme.setYear(year);
		Scheme sc = schemeService.addScheme(scheme);
		
		if(sc.equals(scheme)) {
			
			return ResponseEntity.ok().body(HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/schemes")
	ResponseEntity<Object> getSchemes(){
		List<Scheme> schemes = schemeService.getAllSchemes();
		
		return ResponseEntity.ok().body(schemes);
	}
	
	@GetMapping("/allschemes")
	ResponseEntity<Object> findAllSchemes(){
		return ResponseEntity.ok().body(schemeService.findAllSchemes());
	}
}
