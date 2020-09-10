package com.app.reports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static com.app.reports.utils.SwaggerApiUtils.IMPORT_API_DETAILS;
import static com.app.reports.utils.SwaggerApiUtils.REQ_METHOD_POST;

import com.app.reports.datatrans.FileType;
import com.app.reports.exception.ExceptionMessage;
import com.app.reports.exception.FileNotSupportedException;
import com.app.reports.model.ReportResponse;
import com.app.reports.service.Reportservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path=CustomerReportController.PATH)
@Api(value=CustomerReportController.PATH)
public class CustomerReportController {
	public static final String PATH = "/files";
	
	@Autowired
	private Reportservice reportService;
	
	public CustomerReportController(Reportservice reportService) {
		this.reportService=reportService;
	}
	
	@ApiOperation(value = IMPORT_API_DETAILS, httpMethod = REQ_METHOD_POST)
	@PostMapping(consumes = { "multipart/form-data" })
	public List<ReportResponse> processData(@RequestParam("file") MultipartFile file) {

		if (!FileType.isCorrectFileType(file.getOriginalFilename()))
			throw new FileNotSupportedException(
					String.format(ExceptionMessage.FILE_VALIDATION_MESSAGE, file.getOriginalFilename()));

		return reportService.readAndValidate(file);

	}

}
