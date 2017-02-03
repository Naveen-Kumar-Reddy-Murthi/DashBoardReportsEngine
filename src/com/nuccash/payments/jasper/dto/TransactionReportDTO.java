package com.nuccash.payments.jasper.dto;

/**
 * @author Aditya Shekhar
 * @version 1.0
 * @since 20/11/2015
 * @copyright Nucleus Software Exports Ltd
 * @Desc Generic DTO for Dashboard Report
 */
public class TransactionReportDTO {

	private String serialNo;
	private String fileName;
	private String customerRefNo;
	private String uploadTime;
	private String summaryCount;
	private String summaryAmount;
	private String authSummaryCount;
	private String authSummaryAmount;
	private String authHoldCount;
	private String authHoldAmount;
	private String confCount;
	private String confAmount;
	private String confParkCount;
	private String confParkAmount;
	private String expCount;
	private String expAmount;
	private String errorCount;
	private String fileStatus;
	private String uploadedBy;
	
	/**
	 * Default Constructor
	 */
	public TransactionReportDTO(){
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterized Constructor
	 */
	public TransactionReportDTO(final String serialNo, final String fileName, final String customerRefNo,
			final String uploadTime, final String summaryCount, final String summaryAmount,
			final String authSummaryCount, final String authSummaryAmount,
			final String authHoldCount, final String authHoldAmount, final String confCount,
			final String confAmount, final String confParkCount, final String confParkAmount,
			final String expCount, final String expAmount, final String errorCount,
			final String fileStatus, final String uploadedBy) {
		super();
		this.serialNo = serialNo;
		this.fileName = fileName;
		this.customerRefNo = customerRefNo;
		this.uploadTime = uploadTime;
		this.summaryCount = summaryCount;
		this.summaryAmount = summaryAmount;
		this.authSummaryCount = authSummaryCount;
		this.authSummaryAmount = authSummaryAmount;
		this.authHoldCount = authHoldCount;
		this.authHoldAmount = authHoldAmount;
		this.confCount = confCount;
		this.confAmount = confAmount;
		this.confParkCount = confParkCount;
		this.confParkAmount = confParkAmount;
		this.expCount = expCount;
		this.expAmount = expAmount;
		this.errorCount = errorCount;
		this.fileStatus = fileStatus;
		this.uploadedBy = uploadedBy;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCustomerRefNo() {
		return customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getSummaryCount() {
		return summaryCount;
	}

	public void setSummaryCount(String summaryCount) {
		this.summaryCount = summaryCount;
	}

	public String getSummaryAmount() {
		return summaryAmount;
	}

	public void setSummaryAmount(String summaryAmount) {
		this.summaryAmount = summaryAmount;
	}

	public String getAuthSummaryCount() {
		return authSummaryCount;
	}

	public void setAuthSummaryCount(String authSummaryCount) {
		this.authSummaryCount = authSummaryCount;
	}

	public String getAuthSummaryAmount() {
		return authSummaryAmount;
	}

	public void setAuthSummaryAmount(String authSummaryAmount) {
		this.authSummaryAmount = authSummaryAmount;
	}

	public String getAuthHoldCount() {
		return authHoldCount;
	}

	public void setAuthHoldCount(String authHoldCount) {
		this.authHoldCount = authHoldCount;
	}

	public String getAuthHoldAmount() {
		return authHoldAmount;
	}

	public void setAuthHoldAmount(String authHoldAmount) {
		this.authHoldAmount = authHoldAmount;
	}

	public String getConfCount() {
		return confCount;
	}

	public void setConfCount(String confCount) {
		this.confCount = confCount;
	}

	public String getConfAmount() {
		return confAmount;
	}

	public void setConfAmount(String confAmount) {
		this.confAmount = confAmount;
	}

	public String getConfParkCount() {
		return confParkCount;
	}

	public void setConfParkCount(String confParkCount) {
		this.confParkCount = confParkCount;
	}

	public String getConfParkAmount() {
		return confParkAmount;
	}

	public void setConfParkAmount(String confParkAmount) {
		this.confParkAmount = confParkAmount;
	}

	public String getExpCount() {
		return expCount;
	}

	public void setExpCount(String expCount) {
		this.expCount = expCount;
	}

	public String getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(String expAmount) {
		this.expAmount = expAmount;
	}

	public String getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * @Override toString()
	 */
	public String toString() {
		StringBuffer buffer =new StringBuffer("");
		buffer.append("TransactionReportDTO [serialNo=");
		buffer.append(serialNo);
		buffer.append(", fileName=");
		buffer.append(fileName);
		buffer.append(", customerRefNo=");
		buffer.append(customerRefNo);
		buffer.append(", uploadTime=");
		buffer.append(uploadTime );
		buffer.append( ", summaryCount=");
		buffer.append(summaryCount);
		buffer.append(", summaryAmount=");
		buffer.append(summaryAmount);
		buffer.append(", authSummaryCount=");
		buffer.append(authSummaryCount);
		buffer.append( ", authSummaryAmount=");
		buffer.append(authSummaryAmount);
		buffer.append(", authHoldCount=");
		buffer.append(authHoldCount);
		buffer.append( ", authHoldAmount=");
		buffer.append( authHoldAmount);
		buffer.append(", confCount=");
		buffer.append(confCount );
		buffer.append(", confAmount=");
		buffer.append(confAmount );
		buffer.append(", confParkCount=");
		buffer.append(confParkCount);
		buffer.append(", confParkAmount=");
		buffer.append(confParkAmount);
		buffer.append(", expCount=");
		buffer.append( expCount );
		buffer.append( ", expAmount=");
		buffer.append( expAmount);
		buffer.append(", errorCount=");
		buffer.append(errorCount);
		buffer.append(", fileStatus=");
		buffer.append( fileStatus);
		buffer.append(", uploadedBy=");
		buffer.append( uploadedBy );
		buffer.append("]");
		 
		 return buffer.toString();
	}
	
}
