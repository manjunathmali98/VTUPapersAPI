package com.linkit.vtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.service.BranchService;
import com.linkit.vtu.service.SchemeService;


@Controller
public class BranchController {
	
	@Autowired
	SchemeService schemeService;
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("/addBranch/{branchName}/{shortcode}/{scheme}")
	ResponseEntity<HttpStatus> addBranch(@PathVariable("scheme") String year,@PathVariable("branchName") String branchName,@PathVariable("shortcode") String shortCode){
		
		Scheme sc = schemeService.getSchemeByYear(year);
		Branch br = new Branch();
		br.setBranchName(branchName);
		br.setScheme(sc);
		br.setShortCode(shortCode);
		Branch branch = branchService.addBranch(br);
		
		if(br.equals(branch)) {
			
			return ResponseEntity.ok().body(HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addsemesters/{branchId}")
	ResponseEntity<HttpStatus> addSemesters(@PathVariable("branchId") Integer branchId){
		
		Branch br = branchService.addSemesters(branchId);
		if(br.getSemesters().size() == 6 )
			return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
		 
		return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/allbranches")
	ResponseEntity<Object> findAllBranches(){
		return ResponseEntity.ok().body(branchService.findAllBranches());
	}
	
	@GetMapping("/{schemeId}/branches")
	ResponseEntity<Object> findAllBranchesByScheme(@PathVariable("schemeId") Integer schemeId){
		return ResponseEntity.ok(branchService.getAllBranchesByScheme(schemeId));
	}
}
