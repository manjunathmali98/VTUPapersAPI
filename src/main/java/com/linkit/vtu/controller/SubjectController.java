package com.linkit.vtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.linkit.vtu.DTO.SubjectPaperDTO;
import com.linkit.vtu.entities.Subject;
import com.linkit.vtu.service.SubjectService;

@CrossOrigin
@Controller
public class SubjectController {
	
	@Autowired 
	SubjectService subjectService;
	
	@PostMapping("/addsubjects/{branchId}/{semesterId}/{filename}")
	ResponseEntity<Object> addsubjects(@PathVariable("filename") String filename, @PathVariable("semesterId") Integer semesterId, @PathVariable("branchId") Integer branchId){
		
		List<Subject> subjectsAdded = subjectService.addSubjectsFromFile(semesterId, branchId, filename);
		//List<Scheme> schemes = schemeService.getAllSchemes();
		return ResponseEntity.ok().body(subjectsAdded);
	}
	
	@GetMapping("/getSubjects/{semesterId}")
	ResponseEntity<Object> getSubjects(@PathVariable("semesterId") Integer semesterId){
				
		return ResponseEntity.ok().body(subjectService.getSubjectsBySemesterMonths(semesterId));
	}
	
	@GetMapping("/papers/{search}")
	ResponseEntity<Object> getPapers(@PathVariable("search") String search){
		
		List<SubjectPaperDTO> subjectsMatch = subjectService.findSubjects(search);
		
		return ResponseEntity.ok().body(subjectsMatch);
		
	}
}
