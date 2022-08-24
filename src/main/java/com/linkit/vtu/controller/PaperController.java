package com.linkit.vtu.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.service.PaperService;

@Controller
@CrossOrigin()
public class PaperController {

	@Autowired
	PaperService paperService;
		
	@PostMapping("/addPapers")
	ResponseEntity<Object> addPapers(@RequestParam String month, @RequestParam String year, @RequestParam String subjectCode) throws IOException{
		
		List<Paper> paper = paperService.addPaper(month, year, subjectCode);
		
		
		return ResponseEntity.ok().body(paper);
	}
	
	@PostMapping("/addpapers")
	ResponseEntity<Object> addPapers(@ModelAttribute Paper paperObj){
		
		List<Paper> paper = paperService.addPaper(paperObj);
		
		return ResponseEntity.ok().body(paper);
	}
	
	@GetMapping("/getpapers/{subjectCode}")
	ResponseEntity<Object> getPapers(@PathVariable("subjectCode") String subjectCode){
		
		return ResponseEntity.ok().body(paperService.findBySubjectCode(subjectCode));
	}
}
