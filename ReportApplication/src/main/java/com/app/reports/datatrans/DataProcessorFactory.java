package com.app.reports.datatrans;



public class DataProcessorFactory {
	
	/**
	 * Bean Factory method which creates implementation type and assign it to DataImporter 
	 * 
	 * @param filename
	 * @return
	 */
	public static DataImporter getFactory(String filename) {
		
		DataImporter importer = null;
		
		if(FileType.isCsvFileType(filename)) {
			importer = new CsvImporter();
		} else if(FileType.isXmlFileType(filename)) {
			importer = new XmlImporter();
		}
		
		return importer;
	}

}
