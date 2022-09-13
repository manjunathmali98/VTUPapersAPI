package com.linkit.vtu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.SubjectPaperDTO;
import com.linkit.vtu.DTO.SubjectResponseDTO;
import com.linkit.vtu.entities.Subject;

@Service
public interface SubjectService {

	List<Subject> getAllSubjectsBySemester(Integer semesterId);

	List<Subject> getBySubjectCode(String subjectCode);

	List<Subject> addSubjectsFromFile(Integer semesterId, Integer branchId, String filename);
	
	List<Subject> addSubjects(Integer semesterId, Integer branchId, List<Subject> subjects);

	List<SubjectPaperDTO> findSubjects(String search);

	SubjectResponseDTO getSubjectsBySemesterMonths(Integer semesterId);
	
}
