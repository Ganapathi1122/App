package com.app.reports.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.reports.model.ReportResponse;

public interface Reportservice {
	
	List<ReportResponse> readAndValidate(MultipartFile file);

}
