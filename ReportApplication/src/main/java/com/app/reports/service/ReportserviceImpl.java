package com.app.reports.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.reports.datatrans.DataImporter;
import com.app.reports.datatrans.DataProcessorFactory;
import com.app.reports.model.Report;
import com.app.reports.model.ReportResponse;

@Service
public class ReportserviceImpl implements Reportservice {
	
	@Override
	public List<ReportResponse> readAndValidate(MultipartFile file) {
		// TODO Auto-generated method stub
		DataImporter importer = DataProcessorFactory.getFactory(file.getOriginalFilename());
		List<Report> reports = importer.doImport(file);

		List<Report> validationResults = new ArrayList<>();
		validationResults.addAll(collectDuplicateTransactionReferences(reports));
		validationResults.addAll(validateRecordEndBalance(reports));

		return validationResults.stream().map(ReportResponse::new).collect(Collectors.toList());
	}

	private List<Report> collectDuplicateTransactionReferences(List<Report> reports) {
		Map<Long, List<Report>> groupByTransactionRef = reports.stream()
				.collect(Collectors.groupingBy(report -> report.getTransactionReference()));

		List<Report> validationResults = new ArrayList<>();
		
		groupByTransactionRef.forEach((k, v) -> {
			if (v.size() > 1) {
				validationResults.addAll(v);
			}
		});

		return validationResults;
	}

	
	//Validate Endbalance
	
	private List<Report> validateRecordEndBalance(List<Report> reports) {
		return reports.stream().filter(rep -> !isValid(rep)).collect(Collectors.toList());
	}

	private boolean isValid(Report rep) {
		
		
		BigDecimal balancevalu =new BigDecimal(rep.getStartBalance()).add(new BigDecimal(rep.getMutationValue()));
		BigDecimal endbalance =new BigDecimal(rep.getEndBalance());

		BigDecimal expbalanceval= balancevalu.setScale(2, RoundingMode.HALF_UP);
		BigDecimal expendbalanceval = endbalance.setScale(2, RoundingMode.HALF_UP);
		  
		  
		return expbalanceval.equals(expendbalanceval);
	}
}
