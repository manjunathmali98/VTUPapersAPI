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

	@Autowired
	SchemeService schemeService;
	
	@Autowired
	BranchService brService;
	
	@Autowired
	SemesterService semService;
	
	@Autowired 
	SubjectService subService;
	
	@Autowired
	QPaperService qpService;
	
	@Autowired
	PaperService paperService;
	
	@GetMapping("/home")
	String homePage(Model model) {
		//swathis@zscaler.com
		return "home";
	}
	
	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
	/*
	@PostMapping("/addScheme/{scheme}")
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
	
	@PostMapping("/addBranch/{branchName}/{scheme}")
	ResponseEntity<HttpStatus> addBranch(@PathVariable("scheme") String year,@PathVariable("branchName") String branchName){
		
		Scheme sc = schemeService.getSchemeByYear(year);
		Branch br = new Branch();
		br.setBranchName(branchName);
		br.setScheme(sc);
		Branch branch = brService.addBranch(br);
		
		if(br.equals(branch)) {
			
			return ResponseEntity.ok().body(HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addSemesters/{branchId}")
	ResponseEntity<HttpStatus> addSemesters(@PathVariable("branchId") Integer branchId){
		
		Branch br = brService.addSemesters(branchId);
		if(br.getSemesters().size() == 8 )
			return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
		 
		return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addSubjects/{branchId}/{semesterId}")
	ResponseEntity<Object> addSubjects(@RequestBody Semester semesterObj, @PathVariable("semesterId") Integer semesterId, @PathVariable("branchId") Integer branchId){
		Branch br  = brService.getBranchById(branchId);
		Integer sem = semService.getSem(semesterId).getSem();
		semesterObj.setSem(sem);
		semesterObj.setSemesterId(semesterId);
		semesterObj.setBranch(br);
		semesterObj.getSubjects().forEach(sub -> sub.setSemester(semesterObj));
		semService.addSemester(semesterObj);
	return ResponseEntity.ok().body(semesterObj);
	}
	
	@GetMapping("/addsubjects/{branchId}/{semesterId}/{filename}")
	ResponseEntity<Object> addsubjects(@PathVariable("filename") String filename, @PathVariable("semesterId") Integer semesterId, @PathVariable("branchId") Integer branchId){
		
		List<Subject> subjectsAdded = subService.addSubjectsFromFile(semesterId, branchId, filename);
		//List<Scheme> schemes = schemeService.getAllSchemes();
		return ResponseEntity.ok().body(subjectsAdded);
	}
	@PostMapping("/addPapers/{subjectCode}")
	ResponseEntity<Object> addPapers(@RequestBody Paper paperObj, @PathVariable("subjectCode") String subjectCode){
		
//		Subject sub = subService.getBySubjectCode(subjectCode);
//		
//		paperObj.setSubject(sub);
//		
//		String scheme = sub.getSemester().getBranch().getScheme().getYear();
//		System.out.println(scheme);
//		String shortCode = sub.getSemester().getBranch().getShortCode();
//		int sem = sub.getSemester().getSem();
//		String month = paperObj.getMonth();
//		String year = paperObj.getYear();
//		String fileUrl = String.join("_", scheme, shortCode, String.valueOf(sem), subjectCode, month, year)+".pdf";
//		paperObj.setFileUrl(fileUrl);
		
		Paper paper = paperService.addPaper(paperObj,subjectCode);
		
		return ResponseEntity.ok().body(paper);
	}
	
	@PostMapping("/addQpaper/{fileUrl}")
	ResponseEntity<Object> addQpaper(@RequestBody byte[] file,@PathVariable("fileUrl") String fileUrl){
		Qpaper qp = new Qpaper();
		qp.setDataFile(file);
		Paper paper = paperService.findByFileUrl(fileUrl);
		System.out.println(paper);
		qp.setPaper(paper);
		Qpaper qpp = qpService.addQPaper(qp);
		return  ResponseEntity.status(HttpStatus.CREATED).body(qpp);
	}
	
	@GetMapping("/schemes")
	ResponseEntity<Object> getSchemes(){
		List<Scheme> schemes = schemeService.getAllSchemes();
		
		return ResponseEntity.ok().body(schemes);
	}
	
	@GetMapping("/paper/{fileUrl}")
	ResponseEntity<byte[]> getQpaper(@PathVariable("fileUrl") String fileUrl){
		
		Qpaper qp = qpService.getQpaperbyFileUrl(fileUrl);
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
		.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + qp.getQpaperId() + "\"")
		.body(qp.getDataFile());
	}
	
	@GetMapping("/subjects")
	ResponseEntity<Object> getSubjects(){
		List<Subject> subjects = subService.getAllSubjectsBySemester();
		return ResponseEntity.ok().body(subjects);
	}
	
	@GetMapping("/allSchemes")
	ResponseEntity<Object> findAllSchemes(){
		return ResponseEntity.ok().body(schemeService.findAllSchemes());
	}
	
	*/
}

