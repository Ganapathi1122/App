package com.app.reports.service;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.reports.model.Report;
import com.app.reports.model.ReportResponse;
;

/**
 * @author Ganapathi T
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportserviceTest {

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private Reportservice reportservice;

	@Test
	public void shouldreadAndValidate() throws Exception {
		List<ReportResponse> results = new ArrayList<>();
		ReportResponse result1 = new ReportResponse(
				new Report(130498L, "NL27SNSB0917829871", 91.23, "+", +15.57, "Clothes for Willem Dekker", 106.8));
		ReportResponse result2 = new ReportResponse(
				new Report(112806L, "NL69ABNA0433647324", 90.83, "-", -10.91, "Clothes for Richard de Vries", 79.92));
		ReportResponse result3 = new ReportResponse(
				new Report(112806L, "NL93ABNA0585619023", 102.12, "+", +45.87, "Tickets from Richard Bakker", 147.99));
		ReportResponse result4 = new ReportResponse(
				new Report(194261L, "NL91RABO0315273637", 21.6, "-", -41.83, "Clothes from Jan Bakker", -20.23));
		ReportResponse result5 = new ReportResponse(
				new Report(179430L, "NL93ABNA0585619023", 23.96, "-", -27.43, "Clothes for Vincent Bakker", -3.47));
		results.add(result1);
		results.add(result2);
		results.add(result3);
		results.add(result4);
		results.add(result5);

		Resource resource = resourceLoader.getResource("classpath:records.csv");
		byte[] csvFileBytes = Files.readAllBytes(resource.getFile().toPath());

		MockMultipartFile mockCsvFile = new MockMultipartFile("data", "records.csv", "text/plain", csvFileBytes);

		Assert.assertEquals(results.get(0).getDescription(),
				reportservice.readAndValidate(mockCsvFile).get(0).getDescription());

	}

}
