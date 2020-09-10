package com.app.reports.datatrans;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.app.reports.model.Report;

/**
 * Implementation of {@link DataImporter}
 * 
 * @author Ganapathi T
 *
 */
public class XmlImporter implements DataImporter {

	private SAXParser createSaxParser() {
		SAXParser saxParser = null;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			saxParser = factory.newSAXParser();
			return saxParser;
		} catch (ParserConfigurationException | SAXException ex) {
			ex.printStackTrace();
		}
		return saxParser;
	}

	@Override
	public List<Report> doImport(MultipartFile file) {
		MyCustomHandler handler = new MyCustomHandler();
		try {
			SAXParser parser = createSaxParser();
			parser.parse(file.getInputStream(), handler);

		} catch (SAXException | IOException ex) {
			ex.printStackTrace();
		}
		return handler.getUsers();
	}

}