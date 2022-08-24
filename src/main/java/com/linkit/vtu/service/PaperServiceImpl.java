package com.linkit.vtu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Subject;
import com.linkit.vtu.repository.PaperRepository;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	PaperRepository pRepo;
	
	@Autowired
	QPaperService qpaperService;
	
	@Autowired 
	SubjectService subjectService;
	
	@Override
	public Paper getByfileUrl(String fileUrl) {
		
		return pRepo.findByFileUrl(fileUrl);
	}


	public List<Paper> addPaper(Paper paperObj) {
		
		System.out.println(paperObj);
		
		String subjectCode = paperObj.getSubjectCode();
		
		List<Subject> subjects = subjectService.getBySubjectCode(subjectCode);
		
		List<Paper> addedPapers = new ArrayList<>();
		
		Paper paper = null;
		
		for(Subject sub: subjects) {
			
			paperObj.setSubject(sub);
			System.out.println("subject is "+sub);
			
			String scheme = sub.getSemester().getBranch().getScheme().getYear();
			String shortCode = sub.getSemester().getBranch().getShortCode();
			int sem = sub.getSemester().getSem();
			String month = paperObj.getMonth();
			String year = paperObj.getYear();
			Stream<String> subArray = Arrays.asList(sub.getSubjectName().toLowerCase().split(" ")).stream();
			String sub_name  = subArray.collect(Collectors.joining("_"));
			
			System.out.println("sub name is"+sub_name);
			String fileName = String.join("_", scheme,  shortCode, String.valueOf(sem), sub.getSubjectCode(), month.toLowerCase(), year);
			System.out.println("sub name is"+fileName);
			String fileUrl = String.join("/", scheme, shortCode, "SEM_"+String.valueOf(sem), sub_name, fileName)+".pdf";
			System.out.println("file Url is"+ fileUrl);
			paperObj.setFileUrl(fileUrl);
			
			paper = pRepo.save(paperObj);
			
			addedPapers.add(paper);
		}
		
		/*
		Qpaper qp = new Qpaper();
		qp.setPaper(paper);
		try {
			qp.setDataFile(file.getBytes());
		} catch (IOException e) {
			System.out.println("Input File Exception");			
			e.printStackTrace();
		}
		
		qpaperService.addQPaper(qp);
		*/
		return addedPapers;
	}


	public Paper findByFileUrl(String fileUrl) {
		
		return pRepo.findByFileUrl(fileUrl);
	}


	@Override
	public List<Paper> findBySubjectCode(String subjectCode) {
		
		
		return pRepo.findAllBySubjectCode(subjectCode);
	}


	@Override
	public List<Paper> addPaper(String month, String year, String subjectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public Paper addPaper(String Month, String Year, String subjectCode) {
		
		Subject sub = subjectService.getBySubjectCode(subjectCode);
		
		System.out.println(Month);
		System.out.println(subjectCode);
		Paper paperObj = new Paper();
		paperObj.setSubject(sub);
		paperObj.setMonth(Month);
		paperObj.setYear(Year);
		
		System.out.println(sub);
		
		String scheme = sub.getSemester().getBranch().getScheme().getYear();
		String shortCode = sub.getSemester().getBranch().getShortCode();
		int sem = sub.getSemester().getSem();
		String month = paperObj.getMonth();
		String year = paperObj.getYear();
		Stream<String> subArray = Arrays.asList(sub.getSubjectName().toLowerCase().split(" ")).stream();
		String sub_name  = subArray.collect(Collectors.joining("_"));
		
		System.out.println("sub name is"+sub_name);
		String fileName = String.join("_", scheme,  shortCode, String.valueOf(sem), sub.getSubjectCode(), month.toLowerCase(), year);
		System.out.println("sub name is"+fileName);
		String fileUrl = String.join("/", scheme, shortCode, "SEM_"+String.valueOf(sem), sub_name, fileName)+".pdf";
		System.out.println("file Url is"+ fileUrl);
		paperObj.setFileUrl(fileUrl);
		
		Paper paper = pRepo.save(paperObj);
		return paper;
	}
*/
	
}
