package com.linkit.vtu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.linkit.vtu.entities.Branch;
import com.linkit.vtu.entities.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {

	Semester findBySemesterId(Integer semesterId);

	Semester findByBranchAndSem(Branch branch, Integer sem);

	@Modifying
	@Query(value="select * from semester where branch_id = ?1", nativeQuery= true)
	List<Semester> findByBranchId(Integer branchId);

}
