package com.linkit.vtu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.linkit.vtu.entities.Paper;

public interface PaperRepository extends JpaRepository<Paper, String> {

	Paper findByFileUrl(String fileUrl);
	
	@Query(value="select * from paper where subject_code =?1", nativeQuery= true)
	@Modifying
	List<Paper> findAllBySubjectCode(String subjectCode);

}
