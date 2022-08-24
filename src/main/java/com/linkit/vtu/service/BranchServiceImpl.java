package com.linkit.vtu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.BranchDTO;
import com.linkit.vtu.DTO.SchemeDTO;
import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Scheme;
import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchRepository brRepo;
	
	@Override
	public Branch addBranch(Branch br) {
		return brRepo.save(br);
		
	}

	
	@Override
	public List<Branch> getAllBranches() {
		List<Branch> branches = brRepo.findAll();
		
		return branches;
	}

	@Override
	public Branch addSemesters(Integer branchId) {
		Branch branch = brRepo.findByBranchId(branchId);
		List<Semester> semesters = new ArrayList<Semester>();
		for(int i=3; i<9; i++){
			Semester sem = new Semester();
			sem.setBranch(branch);
			sem.setSem(i);
			semesters.add(sem);
		}
		branch.setSemesters(semesters);
		brRepo.save(branch);
		return branch;
	}


	@Override
	public Branch getBranchById(Integer branchId) {
		Branch br = brRepo.findByBranchId(branchId);
		return br;
	}


	@Override
	public List<BranchDTO> findAllBranches() {
		
		List<Branch> branches = brRepo.findAll();
		System.out.println(branches);
		List<BranchDTO> allBranches = new ArrayList<BranchDTO>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (Branch Obj : branches) {
			
			BranchDTO branch = modelMapper.map(Obj, BranchDTO.class);
			allBranches.add(branch);
		}
		
		return allBranches;
	}


	@Override
	public List<BranchDTO> getAllBranchesByScheme(Integer schemeId) {
		
		List<Branch> branches = brRepo.findAllByScheme(schemeId);
		
		System.out.println(branches);
		List<BranchDTO> allBranches = new ArrayList<BranchDTO>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (Branch Obj : branches) {
			
			BranchDTO branch = modelMapper.map(Obj, BranchDTO.class);
			allBranches.add(branch);
		}
		
		return allBranches;
		
	}

}
