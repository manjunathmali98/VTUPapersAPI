package com.linkit.vtu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.SchemeDTO;
import com.linkit.vtu.DTO.SemesterDTO;
import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.repository.SemesterRepository;

@Service
public class SemesterServiceImpl implements SemesterService {
	
	@Autowired
	SemesterRepository semRepo;
	
	@Override
	public void addSemester(Semester sem) {
		semRepo.save(sem);
		
	}

	@Override
	public List<Semester> getAllSemesters() {
		
		return semRepo.findAll();
	}

	@Override
	public Semester getSem(Integer semesterId) {
		
		return semRepo.findBySemesterId(semesterId);
	}

	@Override
	public Semester getSem(Branch branch, Integer sem) {
		
		return semRepo.findByBranchAndSem(branch,sem);
	}

	@Override
	public List<SemesterDTO> getAllSemestersByBranchId(Integer branchId) {
		
		List<Semester> sems = semRepo.findByBranchId(branchId);
		
		List<SemesterDTO> allSems = new ArrayList<SemesterDTO>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (Semester Obj : sems) {
			
			SemesterDTO sem= modelMapper.map(Obj, SemesterDTO.class);
			allSems.add(sem);
		}
		return allSems;
	}

}
