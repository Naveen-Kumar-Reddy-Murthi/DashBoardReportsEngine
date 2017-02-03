package com.nuccash.payments.jasper.dto;

/**
 * @author Naveen Reddy
 * @version 1.0
 * @since 18/11/2015
 * @copyright Nucleus Software Exports Ltd
 * @Desc Generic DTO for Advice Uploads Report
 */
public class AdviceReportDTO {

	private String serialNo;
	private String fileName;
	private String customerRefNo;
	private String uploadTime;
	private String txnSuccessAmount;
	private String txnSuccessCount;
	private String txnErrorCount;
	private String txnTotalCount;
	private String anxSuccessCount;
	private String anxErrorCount;
	private String anxTotal;
	private String totalCount;
	private String fileStatus;
	private String maker;

	/**
	 * Default Constructor
	 */
	public AdviceReportDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterized Constructor
	 */
	public AdviceReportDTO(final String serialNo, final String fileName,
			final String customerRefNo, final String uploadTime, final String txnSuccessAmount,
			final String txnSuccessCount, final String txnErrorCount, final String txnTotalCount,
			final String anxSuccessCount, final String anxErrorCount, final String anxTotal,
			final String totalCount, final String fileStatus, final String maker) {
		super();
		this.serialNo = serialNo;
		this.fileName = fileName;
		this.customerRefNo = customerRefNo;
		this.uploadTime = uploadTime;
		this.txnSuccessAmount = txnSuccessAmount;
		this.txnSuccessCount = txnSuccessCount;
		this.txnErrorCount = txnErrorCount;
		this.txnTotalCount = txnTotalCount;
		this.anxSuccessCount = anxSuccessCount;
		this.anxErrorCount = anxErrorCount;
		this.anxTotal = anxTotal;
		this.totalCount = totalCount;
		this.fileStatus = fileStatus;
		this.maker = maker;
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

	public String getTxnSuccessAmount() {
		return txnSuccessAmount;
	}

	public void setTxnSuccessAmount(String txnSuccessAmount) {
		this.txnSuccessAmount = txnSuccessAmount;
	}

	public String getTxnSuccessCount() {
		return txnSuccessCount;
	}

	public void setTxnSuccessCount(String txnSuccessCount) {
		this.txnSuccessCount = txnSuccessCount;
	}

	public String getTxnErrorCount() {
		return txnErrorCount;
	}

	public void setTxnErrorCount(String txnErrorCount) {
		this.txnErrorCount = txnErrorCount;
	}

	public String getTxnTotalCount() {
		return txnTotalCount;
	}

	public void setTxnTotalCount(String txnTotalCount) {
		this.txnTotalCount = txnTotalCount;
	}

	public String getAnxSuccessCount() {
		return anxSuccessCount;
	}

	public void setAnxSuccessCount(String anxSuccessCount) {
		this.anxSuccessCount = anxSuccessCount;
	}

	public String getAnxErrorCount() {
		return anxErrorCount;
	}

	public void setAnxErrorCount(String anxErrorCount) {
		this.anxErrorCount = anxErrorCount;
	}

	public String getAnxTotal() {
		return anxTotal;
	}

	public void setAnxTotal(String anxTotal) {
		this.anxTotal = anxTotal;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * @Override toString()
	 */
	public String toString() {
		StringBuffer buffer =new StringBuffer("");
		buffer.append("AdviceReportDTO [serialNo=");
		buffer.append(serialNo);
		buffer.append(", fileName=");
		buffer.append(fileName);
		buffer.append(", customerRefNo=");
		buffer.append(customerRefNo);
		buffer.append(", uploadTime="); 
		buffer.append(uploadTime );
		buffer.append(", txnSuccessAmount=");
		buffer.append(txnSuccessAmount );
		buffer.append(", txnSuccessCount=");
		buffer.append( txnSuccessCount);
		buffer.append(", txnErrorCount=");
		buffer.append(txnErrorCount);
		buffer.append( ", txnTotalCount=");
		buffer.append( txnTotalCount );
		buffer.append(", anxSuccessCount=");
		buffer.append(anxSuccessCount);
		buffer.append(", anxErrorCount=");
		buffer.append(anxErrorCount);
		buffer.append( ", anxTotal=");
		buffer.append(anxTotal);
		buffer.append(", totalCount=");
		buffer.append(totalCount);
		buffer.append(", fileStatus=");
		buffer.append(fileStatus);
		buffer.append(", maker=" );
		buffer.append(maker );
		buffer.append("]");;
		return buffer.toString();
	}

}
