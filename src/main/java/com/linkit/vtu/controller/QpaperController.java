package com.linkit.vtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Qpaper;
import com.linkit.vtu.service.PaperService;
import com.linkit.vtu.service.QPaperService;

@Controller
public class QpaperController {

	@Autowired
	QPaperService qpaperService;
	
	@Autowired
	PaperService paperService;
	
	@PostMapping("/addQpaper/{fileUrl}")
	ResponseEntity<Object> addQpaper(@RequestBody byte[] file,@PathVariable("fileUrl") String fileUrl){
		
		Qpaper qp = new Qpaper();
		qp.setDataFile(file);
		
		Paper paper = paperService.findByFileUrl(fileUrl);
		qp.setPaper(paper);
		
		Qpaper qpp = qpaperService.addQPaper(qp);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(qpp);
	}
	
	@GetMapping("/paper/{fileUrl}")
	ResponseEntity<Object> getQpaper(@PathVariable("fileUrl") String fileUrl){
		
		try {
			Qpaper qp = qpaperService.getQpaperbyFileUrl(fileUrl);
			
			return ResponseEntity
					.ok()
					.contentType(MediaType.parseMediaType("application/pdf"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + qp.getQpaperId() + "\"")
					.body(qp.getDataFile());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested file does not exist on the server");
		}
		
			
		
		
	}
}
