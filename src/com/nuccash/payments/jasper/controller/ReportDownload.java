package com.nuccash.payments.jasper.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import com.google.gson.JsonSyntaxException;
import com.nuccash.payments.jasper.helper.ReportGenerator;


/**
 * @author Naveen Reddy
 * @version 1.0
 * @since 20/11/2015
 * @Desc Servlet called for downloading report
 */

@WebServlet("/ReportDownload")
public class ReportDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 * 		 HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream outputStream = response.getOutputStream();
		byte [] reportData		  = null;
		int    reportDataLength   =    0;
		List <String> paramList	  = new ArrayList<String>();
		ServletContext servletContext = request.getSession().getServletContext();
		String relativeWebPath = "images/logo_bank_new1.jpg";
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		System.out.println("absoluteDiskPath::"+absoluteDiskPath);
    	String formatType		  =		request.getParameter("option");
		String type      		  =		request.getParameter("type");
		String fileName	 		  =		"";
		String contextPath		  =		request.getScheme()	+ "://" +request.getServerName()  + ":" +request.getServerPort() +request.getContextPath()+"/";
		System.out.println("contextPath::"+contextPath);
		paramList.add(request.getParameter("option"));
		paramList.add(request.getParameter("jsonString"));
		paramList.add(request.getParameter("fromDate"));
		paramList.add(request.getParameter("toDate"));
		paramList.add(request.getParameter("userName"));
		paramList.add(contextPath);
		paramList.add(request.getParameter("reportName"));
		//System.out.println("paramList:"+paramList);
		try{	
			ReportGenerator generate = new ReportGenerator();
				if("AdviceReport".equalsIgnoreCase(type))
					reportData = generate.adviceReport(paramList);
				else if("OtherReport".equalsIgnoreCase(type))
					reportData = generate.otherReport(paramList);
				else if("DashBoardReport".equalsIgnoreCase(type))
					reportData = generate.generateDashboardReport(paramList);

				fileName=   generate.generateFileName(type,formatType.toLowerCase());
				reportDataLength=reportData.length;
				response=generate.setHeaderParams(response, formatType, fileName, reportDataLength);		
				outputStream.write(reportData);
		  }
		  catch(JRException e){
				e.printStackTrace();
		        }
		 catch(JsonSyntaxException e){
			 e.printStackTrace();
			    }
		 catch(ClassCastException e){
			 e.printStackTrace();
		        }
		
		finally{
			    outputStream.flush();
			    outputStream.close();
		}
	}
}
