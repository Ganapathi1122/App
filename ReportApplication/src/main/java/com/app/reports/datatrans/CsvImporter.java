package com.app.reports.datatrans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.reports.exception.ExceptionMessage;
import com.app.reports.exception.InvalidFieldLengthException;
import com.app.reports.model.Report;
import com.app.reports.utils.ValidationUtils;


/**
 * 
 * 
 * @author Ganapathi T
 *
 */
public class CsvImporter implements DataImporter {

	private static final String CSV_SPLIT_BY = ",";
	
	@Override
	public List<Report> doImport(MultipartFile file) {

		List<Report> reports = new ArrayList<>();
		
		try {
            InputStream inputStream = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            br.lines()
              .skip(1)
              .forEachOrdered(line -> {
            	
            	String[] tokens = line.split(CSV_SPLIT_BY);
                if(tokens.length == 6) {
                	Report report = new Report();
                	report.setTransactionReference(ValidationUtils.validateAndGetTransactionReference(tokens[0]));
                	report.setAccountNumber(ValidationUtils.validateAndGetAccountNumber(tokens[1]));
                	report.setDescription(tokens[2]);
                	report.setStartBalance(Double.parseDouble(tokens[3]));
                	report.setMutationSymbol(ValidationUtils.getMutationSymbol(tokens[4]));
                	report.setMutationValue(ValidationUtils.getMutationValue(tokens[4]));
                	report.setEndBalance(Double.parseDouble(tokens[5]));
                	reports.add(report);
                } else {
                	throw new InvalidFieldLengthException(String.format(ExceptionMessage.INVALID_CSV_LINE, line));
                }
            });
            
        }catch (IOException e) {
            e.printStackTrace();
        }
		
		return reports;
	}

}
