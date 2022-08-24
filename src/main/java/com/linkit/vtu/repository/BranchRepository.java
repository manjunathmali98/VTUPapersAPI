package com.linkit.vtu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.linkit.vtu.entities.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	Branch findByBranchId(Integer branchId);
	
	@Modifying
	@Query(value="select * from branch where scheme_id = ?1",nativeQuery = true)
	List<Branch> findAllByScheme(Integer schemeId);

}
