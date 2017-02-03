package com.nuccash.payments.jasper.common;

/**
 * @author Naveen Reddy
 * @version 1.0
 * @since 23/11/2015
 * @Desc Class contains constants used in report generation
 */
public final class Constants {
	
	/**
	 * Compiled jasper design file path for transaction dashboard report
	 */
	public static final String DASHBOARD_JASPER = "D:\\JasperWorkSpace\\FileUploadStatusReport\\DashBoardReport.jasper"; 
	
	/**
	 * temp folder path for saving html files
	 */
	public static final String TEMP_OPERATION = "D:\\JunoWorkSpace\\DashBoardReports\\temp\\";
    
    /**
	 * Compiled jasper design file path for process id 111,112 reports
	 */
	public static final String ADVICE_JASPER="D:\\JasperWorkSpace\\FileUploadStatusReport\\FileUpldStatusReport.jasper";
   
    /**
	 * Compiled jasper design file path for process id 143,166,178 reports
	 */
	public static final String OTHER_JASPER="D:\\JasperWorkSpace\\FileUploadStatusReport\\OtherReports.jasper";	
	
	/**
	 * Delimiter used for generating report in text format
	 */
	public static final char DELIMITER ='~';
	
	/**
	 * Used as header in report for text format
	 */
	public static final char HEADER ='H';
	
	/**
	 * Used as header in report for text format
	 */
	public static final char DETAIL ='D';
	
	/**
	 * Used as line seperator in report for text format
	 */
	public static final String NEW_LINE =System.getProperty("line.separator");
	
	/**
	 * Used for comparing input format
	 */
	public static final String PDF ="PDF";
	
	/**
	 * Used for comparing input format
	 */
	public static final String XLS ="XLS";
	
	/**
	 *Used for comparing input format
	 */
	public static final String HTML ="HTML";
	
	/**
	 * Used for comparing input format
	 */
	public static final String TXT ="TXT";
	
	

	/**
	 * 
	 */
	private Constants() {
		// restrict initialization
	}

	
}
