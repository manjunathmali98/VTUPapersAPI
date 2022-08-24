package com.linkit.vtu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.linkit.vtu.entities.Paper;
import com.linkit.vtu.entities.Qpaper;

@Service
public interface PaperService {

	Paper getByfileUrl(String fileUrl);

	List<Paper> addPaper(String month, String year, String subjectCode);

	Paper findByFileUrl(String fileUrl);

	List<Paper> findBySubjectCode(String subjectCode);

	List<Paper> addPaper(Paper paperObj);

}
