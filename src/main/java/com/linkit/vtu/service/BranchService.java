package com.linkit.vtu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkit.vtu.DTO.BranchDTO;
import com.linkit.vtu.entities.Branch;

@Service
public interface BranchService {

	Branch addBranch(Branch br);

	List<Branch> getAllBranches();

	Branch addSemesters(Integer branchId);

	Branch getBranchById(Integer branchId);

	List<BranchDTO> findAllBranches();

	List<BranchDTO> getAllBranchesByScheme(Integer schemeId);

}
