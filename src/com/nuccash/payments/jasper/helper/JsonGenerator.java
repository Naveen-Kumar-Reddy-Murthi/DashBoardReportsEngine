package com.nuccash.payments.jasper.helper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.simple.JSONObject;

/**
 * @author Naveen Reddy
 * @version 1.0
 * @since 20/11/2015
 * @copyright Nucleus Software Exports Ltd
 * @Desc Class used for generating Json String equivalent to given DTO class
 */
public final class JsonGenerator {
	
	public JsonGenerator(){
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @author Naveen Reddy
	 * @since 20/11/2015
	 * @param java.util.List
	 * @return java.lang.String
	 * @Desc Used to generate Json String equivalent of OtherReportDTO class		 
	 */
	@SuppressWarnings("unchecked")
	public  String getOtherReportJsonString(final List<String> arrList){
		Map<String, String> data = new ConcurrentHashMap<String, String>();
		StringBuffer buffer= new StringBuffer();
		int counter      =    0;
		String sequence  =   "";
		buffer.append("[\n");
		JSONObject json = new JSONObject();
		for(int i=0;i<arrList.size();i+=12) {
			++counter;
			sequence=counter+" ";
			data.put("serialNo",sequence.trim());
			data.put("fileName", arrList.get(i).trim());
			data.put("successCount",arrList.get(i+4).trim());
			data.put("errorCount", arrList.get(i+5).trim());
			data.put("totalCount",arrList.get(i+6).trim());
			data.put("totalAmount",arrList.get(i+7).trim());
			data.put("fileStatus",arrList.get(i+3).trim());
			data.put("uploadTime",arrList.get(i+2).trim());
			data.put("maker",arrList.get(i+1).trim());
			json.putAll(data);
			buffer.append(json.toString());
			if(i!=arrList.size()-12){
				buffer.append(", ");
			}
		}
		buffer.append("\n]");
		return buffer.toString();
	}
	
	/**
	 * @author Naveen Reddy
	 * @since 20/11/2015
	 * @param java.util.List
	 * @return java.lang.String
	 * @Desc Used to generate Json String equivalent of AdviceReportDTO class
	 */
	@SuppressWarnings("unchecked")
	public  String getAdviceReportJsonString(final List<String> arrList){
		Map<String, String> data = new ConcurrentHashMap<String, String>();
		StringBuffer buffer= new StringBuffer();
		int counter      =    0;
		String sequence  =   "";
		buffer.append("[\n");
		JSONObject json = new JSONObject();
		for(int i=0;i<arrList.size();i+=16) {
			++counter;
			sequence=counter+" ";
			data.put("serialNo",sequence.trim());
			data.put("fileName", arrList.get(i).trim());
			data.put("customerRefNo",arrList.get(i+9).trim());
			data.put("txnSuccessAmount",arrList.get(i+7).trim());
			data.put("txnSuccessCount",arrList.get(i+4).trim());
			data.put("txnErrorCount",arrList.get(i+5).trim());
			data.put("txnTotalCount",arrList.get(i+6).trim());
			data.put("anxSuccessCount",arrList.get(i+12).trim()); 
			data.put("anxErrorCount",arrList.get(i+13).trim());
			data.put("anxTotal",arrList.get(i+14).trim());
			data.put("totalCount",arrList.get(i+15).trim());
			data.put("fileStatus",arrList.get(i+3).trim());
			data.put("uploadTime",arrList.get(i+2).trim());
			data.put("maker",arrList.get(i+1).trim());
			json.putAll(data);
			buffer.append(json.toString());
			if(i!=arrList.size()-16){
				buffer.append(", ");
			}
		}
		buffer.append("\n]");
		return buffer.toString();
	}
}
