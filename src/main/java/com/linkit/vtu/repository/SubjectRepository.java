package com.linkit.vtu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.linkit.vtu.entities.Semester;
import com.linkit.vtu.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
	
	@Query(value="select * from subject where subject_code = ?1", nativeQuery = true)
	List<Subject> findBySubjectCode(String subjectCode);

	List<Subject> findAllBySemester(Semester semester);

	@Query(value="select * from subject where LOWER(subject_code) like %?1% or LOWER(subject_name) like %?1%", nativeQuery = true)
	List<Subject> find(String search);
	
}
