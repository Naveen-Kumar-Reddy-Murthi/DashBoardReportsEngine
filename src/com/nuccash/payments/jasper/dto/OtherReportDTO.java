package com.nuccash.payments.jasper.dto;

/**
 * @author Naveen Reddy
 * @version 1.0
 * @since 18/11/2015
 * @copyright Nucleus Software Exports Ltd
 * @Desc Generic DTO for Other Uploads Report
 */
public class OtherReportDTO {

	private String serialNo;
	private String fileName;
	private String successCount;
	private String errorCount;
	private String totalCount;
	private String totalAmount;
	private String fileStatus;
	private String uploadTime;
	private String maker;

	
	/**
	 * Default Constructor
	 */
	public OtherReportDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterized Constructor
	 */
	public OtherReportDTO(final String serialNo, final String fileName,
			final String successCount, final String errorCount, final String totalCount,
			final String totalAmount, final String fileStatus, final String uploadTime,
			final String maker) {
		super();
		this.serialNo = serialNo;
		this.fileName = fileName;
		this.successCount = successCount;
		this.errorCount = errorCount;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.fileStatus = fileStatus;
		this.uploadTime = uploadTime;
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

	public String getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(String successCount) {
		this.successCount = successCount;
	}

	public String getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
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
		StringBuffer buffer =new StringBuffer();
		buffer.append("OtherReportDTO [serialNo=");
		buffer.append("serialNo");
		buffer.append(", fileName=");
		buffer.append(fileName);
		buffer.append(", successCount=");
		buffer.append(successCount);
		buffer.append(", errorCount=");
		buffer.append( errorCount );
		buffer.append(", totalCount=");
		buffer.append(totalCount);
		buffer.append(", totalAmount=");
		buffer.append( totalAmount );
		buffer.append(", fileStatus="); 
		buffer.append(fileStatus);
		buffer.append(", uploadTime=");
		buffer.append(uploadTime);
		buffer.append(", maker=");
		buffer.append(maker );
		buffer.append("]");
		 return buffer.toString();
	}

}
