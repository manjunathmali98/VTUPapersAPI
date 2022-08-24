package com.linkit.vtu.utils;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.entities.Subject;
import com.linkit.vtu.service.BranchService;
import com.linkit.vtu.service.SchemeService;
import com.linkit.vtu.service.SchemeServiceImpl;
import com.linkit.vtu.service.SemesterService;
import com.linkit.vtu.service.SubjectService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class AddSubjectByCsv {

	@Autowired
	SchemeService schemeService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	SemesterService semService;
	
	@Autowired
	BranchService brService;
	
	public void readAllDataAtOnce()
	{
	try {
		
		//reading as a spring resource from resource folder
		File filename = ResourceUtils.getFile("classpath:15_CS_3.csv");
		
		//overloading file reader and passing the file itself
		FileReader filereader = new FileReader(filename);
		
		//using openCsv dependency
		CSVReader csvReader = new CSVReaderBuilder(filereader)
	            //.withSkipLines(1)
	            .build();
		
		List<String[]> allData = csvReader.readAll();
		
		List<Subject> subjects = new ArrayList<>();
		
		Semester semester = new Semester();
		
		 for (String[] row : allData) {
			 
			 Subject subject = new Subject();
			 System.out.println(row[0]);
             subject.setSubjectCode(row[0]);
             subject.setSubjectName(row[1]);
             System.out.println(row[3]);
             
             Scheme sc = new SchemeServiceImpl().getSchemeByYear(row[3]);
             
             Branch branch = new Branch();
             if(row[4].equals("CS"))
             {
            	 branch.setBranchName("Computer Science");
             }
             branch.setShortCode(row[4]);
             branch.setScheme(sc);
             
             Branch br = brService.addBranch(branch);
             brService.addSemesters(br.getBranchId());
             
	         Semester sem = semService.getSem(br, Integer.parseInt(row[2]));
	         
	         
	         //subject.setSemester(sem);
	         
	         semester = new Semester(sem);
	         
	         subjects.add(subject);
	         
	         
	        }
		 semester.setSubjects(subjects);
		 System.out.println(semester);
		 
		 //semService.addSemester(semester);
	}
	catch(Exception e) {
		 e.printStackTrace();
	}
	}
	
}
