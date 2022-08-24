package com.linkit.vtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.linkit.vtu.service.SemesterService;

@Controller
@CrossOrigin
public class SemesterController {
	
	@Autowired
	SemesterService semesterService;
	
	@GetMapping("{branchId}/semesters")
	ResponseEntity<Object> getAllSemesters(@PathVariable("branchId") Integer branchId){

		return ResponseEntity.ok().body(semesterService.getAllSemestersByBranchId(branchId));
	}
}
