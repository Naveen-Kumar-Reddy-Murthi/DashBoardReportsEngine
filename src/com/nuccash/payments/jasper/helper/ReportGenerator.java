package com.nuccash.payments.jasper.helper;

import static com.nuccash.payments.jasper.common.Constants.ADVICE_JASPER;
import static com.nuccash.payments.jasper.common.Constants.DASHBOARD_JASPER;
import static com.nuccash.payments.jasper.common.Constants.DELIMITER;
import static com.nuccash.payments.jasper.common.Constants.DETAIL;
import static com.nuccash.payments.jasper.common.Constants.HEADER;
import static com.nuccash.payments.jasper.common.Constants.HTML;
import static com.nuccash.payments.jasper.common.Constants.NEW_LINE;
import static com.nuccash.payments.jasper.common.Constants.OTHER_JASPER;
import static com.nuccash.payments.jasper.common.Constants.PDF;
import static com.nuccash.payments.jasper.common.Constants.TEMP_OPERATION;
import static com.nuccash.payments.jasper.common.Constants.TXT;
import static com.nuccash.payments.jasper.common.Constants.XLS;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import com.google.gson.JsonSyntaxException;
import com.nuccash.payments.jasper.dto.AdviceReportDTO;
import com.nuccash.payments.jasper.dto.OtherReportDTO;
import com.nuccash.payments.jasper.dto.TransactionReportDTO;
import com.nuccash.payments.jasper.service.ReportService;

/**
 * @author Aditya Shekhar
 * @version 1.0
 * @since 20/11/2015
 * @copyright Nucleus Software Exports Ltd
 * @Desc This class is used for generating reports in byte[]    
 */
public final class ReportGenerator  {
	
	
	/**
	 * @author Aditya Shekhar
	 * @version 1.0
	 * @since 20/11/2015
	 * @param java.util.List List of parameters
	 * @return byte array of report data
	 * @throws JRException,IOException
	 */
	@SuppressWarnings("unchecked")
	public byte[] generateDashboardReport(final List <String> paramList) throws JRException, IOException, JsonSyntaxException, ClassCastException {
	    ByteArrayOutputStream baos  			= 			 new ByteArrayOutputStream();
		JasperPrint jPrint						=			 null;
		String option							=			 paramList.get(0);
		String userName							=			 paramList.get(4);
		ReportService		service				=   new ReportService();
		String jrxmlFile = "D:\\JasperWorkSpace\\FileUploadStatusReport\\DashBoardReport.jrxml";
		JasperCompileManager.compileReportToFile(jrxmlFile, DASHBOARD_JASPER);
		List<TransactionReportDTO> dataBeanList = service.getDashboardDTOListFromJSON(paramList.get(1));
		JRDataSource jds = new JRBeanArrayDataSource(dataBeanList.toArray());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", paramList.get(2));
		parameters.put("toDate", paramList.get(3));
		parameters.put("userName", paramList.get(4));
		parameters.put("imageUrl", paramList.get(5)+"/logo_bank_new1.jpg");
		Map<String, Object>[] masterData = new HashMap[1];
		masterData[0] = new HashMap<String, Object>();
		masterData[0].put("dataBeanList", jds);
		byte[] byteStream = null;
		if(PDF.equalsIgnoreCase(option)){
			/**
			 * 1- export to PDF
			 */
			byteStream = JasperRunManager.runReportToPdf(DASHBOARD_JASPER, parameters, new JRMapArrayDataSource(masterData));
		} else if(HTML.equalsIgnoreCase(option)){
			/**
			 * 2- export to HTML
			 */
			jPrint = JasperFillManager.fillReport(DASHBOARD_JASPER, parameters, new JRMapArrayDataSource(masterData));
			String htmlFile = TEMP_OPERATION + new Date().getTime()  + userName + ".html";
			JasperExportManager.exportReportToHtmlFile(jPrint, htmlFile);
			byte[] buf = new byte[1024];
			File htmlReport = new File(htmlFile);
			FileInputStream fis = new FileInputStream(htmlReport);
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
                            baos.write(buf, 0, readNum);
                        }
			byteStream = baos.toByteArray();
			baos.flush();
			baos.close();
			fis.close();
			htmlReport.delete();
//			
			//
//			JRExporter exporter = new JRHtmlExporter(); 
//			exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8"); 
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint); 
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos); 
//			exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR,Boolean.TRUE); 
//			exporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR_NAME, "./Images/"); 
//			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "/Images/");            
//			exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
//			exporter.exportReport();
//			byteStream = baos.toByteArray();
//			baos.flush();
//			baos.close();
			
		} else if(XLS.equalsIgnoreCase(option)){
			/**
			 * 3- export to Excel sheet
			 */
			JRXlsExporter exporter = new JRXlsExporter();
			jPrint = JasperFillManager.fillReport(DASHBOARD_JASPER, parameters, new JRMapArrayDataSource(masterData));
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.exportReport();
			byteStream = baos.toByteArray();
			baos.flush();
			baos.close();
		} else if(TXT.equalsIgnoreCase(option)){
			/**
			 * 4- export to Text
			 */
			StringBuffer txtReportString = new StringBuffer();
			txtReportString.append(HEADER);
			txtReportString.append("Serial No.~File Name~Customer Ref. No~Upload Time~Batch/File Summary-Count~Batch/File Summary-Amount~");
			txtReportString.append("Authorization Pending Summary-Count~Authorization Pending Summary-Amount~Authorization Pending Summary-Hold Count~");
			txtReportString.append("Authorization Pending Summary-Hold Amount~Confirmation Pending Summary-Count~Confirmation Pending Summary-Amount~");
			txtReportString.append("Confirmation Pending Summary-Park Count~Confirmation Pending Summary-Park Amount~Expired/Rejected Transactions-Count~");
			txtReportString.append("Expired/Rejected Transactions-Amount~Upload Error Count~File Status~Uploaded By");
			txtReportString.append(NEW_LINE);
			int counter = 1;
			for(TransactionReportDTO bean: dataBeanList){
				txtReportString.append(DETAIL);
				txtReportString.append(bean.getSerialNo());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getFileName());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getCustomerRefNo());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getUploadTime());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getSummaryCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getSummaryAmount());	
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getAuthSummaryCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getAuthSummaryAmount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getAuthHoldCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getAuthHoldAmount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getConfCount());	
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getSerialNo());		
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getConfAmount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getConfParkCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getConfParkAmount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getExpCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getExpAmount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getErrorCount());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getFileStatus());
				txtReportString.append(DELIMITER);
				txtReportString.append(bean.getUploadedBy());
				if(counter<dataBeanList.size()){
					txtReportString.append(NEW_LINE);
				}
				counter++;
			}
			byteStream = txtReportString.toString().getBytes();
		}
		return byteStream;
	}
	
	/**
	 * @author Naveen Reddy
	 * @version 1.0
	 * @since 20/11/2015
	 * @param java.util.List List of parameters
	 * @return byte array of report data
	 * @throws JRException, IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public byte[] otherReport(final List <String> paramList ) throws JRException, IOException, JsonSyntaxException, ClassCastException {	
		byte[] byteArray = null;
		JasperPrint printFileName					= 	null;
		List<OtherReportDTO> 	dataBeanList		=	null;
		JRDataSource 				   jds			=   null;
		Map  				   		   parameters	=	null; 
		Map[] 						   masterData   =	null;
		String option								=	"";
		String userName								=	"";
		ReportService					service		=   new ReportService();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
				String jrxmlFile = "D:\\JasperWorkSpace\\FileUploadStatusReport\\OtherReports.jrxml";
				JasperCompileManager.compileReportToFile(jrxmlFile, OTHER_JASPER);
				option			   =   paramList.get(0);		
				userName		   =   paramList.get(4);
				dataBeanList 	   =   service.getOtherBeanList(paramList.get(1).toString());
				jds 			   =   new JRBeanArrayDataSource(dataBeanList.toArray());
				parameters  	   =   new HashMap();
				parameters.put("fromDate", paramList.get(2));
				parameters.put("toDate", paramList.get(3));
				parameters.put("userName", userName);
				parameters.put("imgUrl", paramList.get(5)+"/logo_bank_new1.jpg");
				parameters.put("reportName",paramList.get(6));  
				masterData = new Map[1];
				masterData[0] = new HashMap();
				masterData[0].put("dataBeanList", jds);
				printFileName = JasperFillManager.fillReport(OTHER_JASPER,parameters, new JRMapArrayDataSource(masterData));
					if(PDF.equalsIgnoreCase(option)){
						byteArray=JasperExportManager.exportReportToPdf(printFileName);
					}
					else if(XLS.equalsIgnoreCase(option)){
						JRXlsExporter xlsExporter=new JRXlsExporter();
						xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, printFileName);
						xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
						xlsExporter.exportReport();
						byteArray = baos.toByteArray();
						baos.flush();
						baos.close();
					}
					
					
					else if (HTML.equalsIgnoreCase(option)){
						String htmlFile = TEMP_OPERATION+new Date().getTime()+ userName + ".html";
						JasperExportManager.exportReportToHtmlFile(printFileName, htmlFile);
						byte[] buf = new byte[1024];
						File htmlReport = new File(htmlFile);
						FileInputStream fis = new FileInputStream(htmlReport);
						for (int readNum; (readNum = fis.read(buf)) != -1;) {
			                            baos.write(buf, 0, readNum);
			                        }
						byteArray = baos.toByteArray();
						baos.flush();
						baos.close();
						fis.close();
						htmlReport.delete();
					} 
					else if(TXT.equalsIgnoreCase(option)){
						
//						JRTextExporter txtExporter = new JRTextExporter();
//						txtExporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 100);
//						txtExporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 80);
//						txtExporter.setParameter(JRExporterParameter.JASPER_PRINT, printFileName);
//						txtExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos); 
//						txtExporter.exportReport();
//						byteArray=baos.toByteArray();
//						baos.flush();
//						baos.close();
					
						StringBuffer otherReportString = new StringBuffer();
						otherReportString.append(HEADER);
						otherReportString.append("Serial No.~File Name~Success Count~Error Count~Total Count~Total Amount~File Status~Upload Date Time~Maker");
						otherReportString.append(NEW_LINE);
						//otherReportString.append("DS\n");
						int counter = 1;
						for(OtherReportDTO bean: dataBeanList) {
							otherReportString.append(DETAIL);
							otherReportString.append(bean.getSerialNo());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getFileName());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getSuccessCount());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getErrorCount());	
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getTotalCount());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getTotalAmount());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getFileStatus());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getUploadTime());
							otherReportString.append(DELIMITER);
							otherReportString.append(bean.getMaker());
							if(counter<dataBeanList.size()){
								otherReportString.append(NEW_LINE);
							}
							counter++;
						}
						byteArray = otherReportString.toString().getBytes();	
					}
		return byteArray;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] adviceReport(final List <String> paramList ) throws JRException, IOException, JsonSyntaxException, ClassCastException {
	//
		byte[] byteArray 							=   null;
		JasperPrint printFileName					= 	null;
		List<AdviceReportDTO> dataBeanList			=	null;
		JRDataSource 				   jds			=   null;
		Map  				   		   parameters	=	null; 
		Map[] 						   masterData   =	null;
		String option								=	"";
		String userName								=	"";
		ReportService					service		=   new ReportService();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
				String jrxmlFile = "D:\\JasperWorkSpace\\FileUploadStatusReport\\FileUpldStatusReport.jrxml";
				JasperCompileManager.compileReportToFile(jrxmlFile, ADVICE_JASPER);
				option			   =   paramList.get(0);		
				userName		   =   paramList.get(4);
				dataBeanList 	   =   service.getAdviceBeanList(paramList.get(1));
				jds 			   =   new JRBeanArrayDataSource(dataBeanList.toArray());
				parameters  	   =   new HashMap();
				parameters.put("fromDate", paramList.get(2));
				parameters.put("toDate", paramList.get(3));
				parameters.put("userName", userName);
				parameters.put("imgUrl", paramList.get(5)+"/logo_bank_new1.jpg");
				parameters.put("reportName", paramList.get(6));  
				masterData 		= new Map[1];
				masterData[0] 	= new HashMap();
				masterData[0].put("dataBeanList", jds);
				printFileName	 = JasperFillManager.fillReport(ADVICE_JASPER,parameters, new JRMapArrayDataSource(masterData));
					if(PDF.equalsIgnoreCase(option)){
						byteArray=JasperExportManager.exportReportToPdf(printFileName);
					}
					else if(XLS.equalsIgnoreCase(option)){
						JRXlsExporter xlsExporter=new JRXlsExporter();
						xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, printFileName);
						xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
						xlsExporter.exportReport();
						byteArray = baos.toByteArray();
						baos.flush();
						baos.close();
					}
					else if (HTML.equalsIgnoreCase(option)){
						String htmlFile = TEMP_OPERATION+new Date().getTime()+ userName + ".html";
						JasperExportManager.exportReportToHtmlFile(printFileName, htmlFile);
						byte[] buf = new byte[1024];
						File htmlReport = new File(htmlFile);
						FileInputStream fis = new FileInputStream(htmlReport);
						for (int readNum; (readNum = fis.read(buf)) != -1;) {
			                            baos.write(buf, 0, readNum);
			                        }
						byteArray = baos.toByteArray();
						baos.flush();
						baos.close();
						fis.close();
						htmlReport.delete();
					} 
					else if(TXT.equalsIgnoreCase(option)) {
						
						
//						JRTextExporter txtExporter = new JRTextExporter();
//						txtExporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 100);
//						txtExporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 80);
//						txtExporter.setParameter(JRExporterParameter.JASPER_PRINT, printFileName);
//						txtExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos); 
//						txtExporter.exportReport();
//						byteArray=baos.toByteArray();
//						baos.flush();
//						baos.close();

						StringBuffer adviceReportString = new StringBuffer();
						adviceReportString.append(HEADER);
						adviceReportString.append("Serial No.~File Name~Customer Ref No~Upload Time~Transaction Summary-Success Amount~Transaction Summary-Success Count~" +
								"Transaction Summary-Error Count~Transaction Summary-Total Count~Annexure Summary-Success Count~" +
								"Annexure Summary-Error Count~Annexure Summary-Total Count~Total Count~" +
								"File Status~Maker\n");
						//adviceReportString.append("DS\n");
						int counter = 1;
						for(AdviceReportDTO bean: dataBeanList) {
							adviceReportString.append(DETAIL);
							adviceReportString.append(bean.getSerialNo());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getFileName());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getCustomerRefNo());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getUploadTime());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getTxnSuccessAmount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getTxnSuccessCount());	
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getTxnErrorCount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getTxnTotalCount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getAnxSuccessCount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getAnxErrorCount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getAnxTotal());	
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getTotalCount());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getFileStatus());
							adviceReportString.append(DELIMITER);
							adviceReportString.append(bean.getMaker());
							adviceReportString.append(DELIMITER);
							if(counter<dataBeanList.size()){
								adviceReportString.append(NEW_LINE);
							}
							counter++;
						}
						byteArray = adviceReportString.toString().getBytes();
					}
		return byteArray;
	}
	
	/**
	 * @param Java.lang.String type of report
	 * @return Java.lang.String filename with
	 */
	public String generateFileName(final String type,final String formatType){
		StringBuffer  fileName= new StringBuffer();
		char seperator ='.';
		if("OtherReport".equalsIgnoreCase(type))
			fileName.append("OtherReport");
		else if("AdviceReport".equalsIgnoreCase(type))
			fileName.append("AdviceReport");
		else
			fileName.append("DashBoardReport");

		  fileName.append(new Date().getTime());
		  fileName.append(seperator);
		  fileName.append(formatType);
		
	return fileName.toString();
	}
	

	/**
	 * @params HttpServletResponse, Java.lang.String, Java.lang.String, int
	 * @return HttpServletResponse
	 * @desc used to set header parameters of response object 
	 * based on type of file to be downloaded
	 */
	public HttpServletResponse setHeaderParams(final HttpServletResponse response, final String formatType,final String fileName, final int length){
		
		if(PDF.equalsIgnoreCase(formatType))
			response.setContentType("application/force-download");
		else if(XLS.equalsIgnoreCase(formatType))
			response.setContentType("application/vnd.ms-excel; charset=utf-8");
		else if(TXT.equalsIgnoreCase(formatType))
			response.setContentType("text/plain");
		else if(HTML.equalsIgnoreCase(formatType))
			response.setContentType("text/html");
		response.setContentLength(length);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition","attachment; filename=\"" + fileName+"\"");
		
		return response;
	}
}
