package com.linkit.vtu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.SemesterDTO;
import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Semester;

@Service
public interface SemesterService {

	void addSemester(Semester sem);

	List<Semester> getAllSemesters();

	Semester getSem(Integer semesterId);

	Semester getSem(Branch branch, Integer sem);

	List<SemesterDTO> getAllSemestersByBranchId(Integer branchId);
}
