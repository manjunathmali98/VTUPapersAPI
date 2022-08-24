package com.linkit.vtu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.linkit.vtu.DTO.SubjectPaperDTO;
import com.linkit.vtu.DTO.SubjectResponseDTO;
import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.entities.Subject;
import com.linkit.vtu.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subRepo;
	
	@Autowired
	SemesterService semService;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Override
	public List<Subject> getAllSubjectsBySemester(Integer semesterId) {
		
		Semester semester = semService.getSem(semesterId);
		List<Subject> subjects = subRepo.findAllBySemester(semester);
		return subjects;
	}

//	@Override
//	public Subject getBySubjectCode(String subjectCode) {
//		
//		//System.out.println(subjectCode.getClass().getSimpleName());
//		//if(subRepo.existsById(subjectCode))
//			return subRepo.getAllBySubjectCode(subjectCode);
//		
//		//return null;
//		
//	}
	
	@Override
	public List<Subject> getBySubjectCode(String subjectCode) {
		
		return subRepo.findBySubjectCode(subjectCode);
	}
	
	@Override
	public List<Subject> addSubjectsFromFile(Integer semesterId, Integer branchId, String filename) {
		
		List<Subject> subjects = new ArrayList<>();
		
		try {
			
			
			Resource resource = resourceLoader.getResource("classpath:"+filename);
			
			//reading as a spring resource from resource folder
			//ClassPathResource resource = new ClassPathResource("classpath:"+filename);
			
			//URL Resource = ClassLoader.getResource(filename);
					
			InputStream inputStream = resource.getInputStream();
			
			File file = File.createTempFile(filename, ".csv");
			
			try {
			    FileUtils.copyInputStreamToFile(inputStream, file);
			} finally {
			    IOUtils.closeQuietly(inputStream);
			}
			
			
			
			//overloading file reader and passing the file itself
			FileReader filereader = new FileReader(file);
			
			
			BufferedReader br = new BufferedReader(filereader);
			
			Branch branch = branchService.getBranchById(branchId);
			
			Semester semester = semService.getSem(semesterId);
			semester.setBranch(branch);
			
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Subject subject = new Subject();
				System.out.println(attributes[0].trim().toString());
				System.out.println(attributes[1].trim().toString());
	             subject.setSubjectCode(attributes[0].trim().toString());
	             subject.setSubjectName(attributes[1].trim().toString());
		         subject.setSemester(semester);
		         subjects.add(subject);
				 line = br.readLine();
			}
			 semester.setSubjects(subjects);
			 semService.addSemester(semester);
			 
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		return subjects;
		}

	@Override
	public List<SubjectPaperDTO> findSubjects(String search) {
		
		List<Subject> subjectList = subRepo.find(search.toLowerCase());
		
		List<SubjectPaperDTO> subPaperDTOList = new ArrayList<SubjectPaperDTO>();
		
		for(Subject subject : subjectList) {
			System.out.println(subject.getSubjectCode());
			
			List<Paper> papers = subject.getPapers();
		
			for(Paper paper : papers) {
			
				SubjectPaperDTO subPaperObj = new SubjectPaperDTO();
			
				//subPaperObj.setPaper((Paper) papers.stream().filter(p -> p.getMonth().equalsIgnoreCase("JUN")));
				subPaperObj.setPaper(paper);
				subPaperObj.setSubjectCode(subject.getSubjectCode());
				subPaperObj.setSubjectName(subject.getSubjectName());
				
				subPaperDTOList.add(subPaperObj);
			}
		}
		return subPaperDTOList;		
	}

	@Override
	public SubjectResponseDTO getSubjectsBySemesterMonths(Integer semesterId) {
		
		List<Subject> subjects = getAllSubjectsBySemester(semesterId);
		
		List<SubjectPaperDTO> dec = new ArrayList<SubjectPaperDTO>();
		
		List<SubjectPaperDTO> jun = new ArrayList<SubjectPaperDTO>();
		
		for(Subject subject : subjects) {
			
			List<Paper> papers = subject.getPapers();
		
			for(Paper paper : papers) {
			
				SubjectPaperDTO subPaperObj = new SubjectPaperDTO();
			
				//subPaperObj.setPaper((Paper) papers.stream().filter(p -> p.getMonth().equalsIgnoreCase("JUN")));
				subPaperObj.setPaper(paper);
				subPaperObj.setSubjectCode(subject.getSubjectCode());
				subPaperObj.setSubjectName(subject.getSubjectName());
				subPaperObj.setSubjectId(subject.getSubjectId());
				System.out.println(subPaperObj);
				
				if(paper.getMonth().equalsIgnoreCase("jun")) {
					
					jun.add(subPaperObj);
				}
				
				if(paper.getMonth().equalsIgnoreCase("dec")) {
					dec.add(subPaperObj);
				}
			}
		}
		
		SubjectResponseDTO subResponse = new SubjectResponseDTO(dec, jun);
		
		return subResponse;
	}
		
	}


