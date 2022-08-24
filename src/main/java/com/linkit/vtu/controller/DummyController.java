package com.linkit.vtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Qpaper;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.entities.Subject;
import com.linkit.vtu.service.BranchService;
import com.linkit.vtu.service.PaperService;
import com.linkit.vtu.service.QPaperService;
import com.linkit.vtu.service.SchemeService;
import com.linkit.vtu.service.SemesterService;
import com.linkit.vtu.service.SubjectService;

@RestController
public class DummyController {
	
	@GetMapping("/home")
	String homePage(Model model) {
		return "home";
	}
	
	@RequestMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
}

