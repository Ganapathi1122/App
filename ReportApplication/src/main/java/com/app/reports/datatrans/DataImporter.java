package com.app.reports.datatrans;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.reports.model.Report;

public interface DataImporter {

	
	List<Report> doImport(MultipartFile file);

}
