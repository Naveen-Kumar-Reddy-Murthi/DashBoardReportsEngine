package com.nuccash.payments.jasper.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nuccash.payments.jasper.dto.AdviceReportDTO;
import com.nuccash.payments.jasper.dto.OtherReportDTO;
import com.nuccash.payments.jasper.dto.TransactionReportDTO;

/**
 * @author Aditya Shekhar
 * @version 1.0
 * @since 20/11/2015
 * @Copyright: Nucleus Software Exports Ltd
 * @Desc Class used for generating java.util.List of DTO 
 * classes of specified from given Json String & viceversa
 */
@SuppressWarnings("unchecked")
public  class ReportService {
	
	
	/**
	 * @author Naveen Reddy
	 * @version 1.0
	 * @since 20/11/2015
	 * @param java.util.String
	 * @return ArrayList of AdviceReportDTOs
	 * @throws JsonSyntaxException,ClassCastException
	 */
	public  List<AdviceReportDTO> getAdviceBeanList(final String jsonString) throws JsonSyntaxException,ClassCastException {
		Gson gson = new Gson();
	    JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        JsonArray	jsonArray   = jsonElement.getAsJsonArray();
        ArrayList<AdviceReportDTO> dTOList = gson.fromJson(jsonArray, ArrayList.class);
        //This is done to prevent generic class conversion issues due to Type Erasure
		//Type type = new TypeToken<ArrayList<AdviceReportDTO>>() {}.getType();
		 //ArrayList<AdviceReportDTO> dTOList=gson.fromJson(jsonArray.toString(), type);
	    //return gson.fromJson(jsonArray.toString(), type);
        return dTOList;
	}
	
	/**
	 * @author Naveen Reddy
	 * @version 1.0
	 * @since 20/11/2015
	 * @param java.util.String
	 * @return ArrayList ofOtherReportDTOs
	 * @throws JsonSyntaxException,ClassCastException
	 */
	public  List<OtherReportDTO> getOtherBeanList(final String jsonString) throws JsonSyntaxException,ClassCastException{
		Gson gson = new Gson();
	    JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        JsonArray	jsonArray   = jsonElement.getAsJsonArray();
      //This is done to prevent generic class conversion issues due to Type Erasure
      		Type type = new TypeToken<ArrayList<OtherReportDTO>>() {}.getType();
      		//ArrayList<OtherReportDTO> dTOList=gson.fromJson(jsonArray.toString(), type);
	    return gson.fromJson(jsonArray.toString(), type);
	}
	
	/**
	 * @author Aditya Shekhar
	 * @version 1.0
	 * @since 20/11/2015
	 * @param java.util.String
	 * @return ArrayList of TransactionReportDTOs
	 * @throws JsonSyntaxException,ClassCastException
	 */
	public  List<TransactionReportDTO> getDashboardDTOListFromJSON(final String jsonString)throws JsonSyntaxException,ClassCastException{
		JsonParser  parser = new JsonParser();
        JsonElement elem = parser.parse(jsonString);
        JsonArray jsonArray = elem.getAsJsonArray();
		Gson gson = new Gson();
                //This is done to prevent generic class conversion issues due to Type Erasure
		Type type = new TypeToken<List<TransactionReportDTO>>() {}.getType();
		//List<TransactionReportDTO> dTOList = (List<TransactionReportDTO>) gson.fromJson
//		(jsonArray.toString(), type);
		return (List<TransactionReportDTO>) gson.fromJson(jsonArray.toString(), type);
	}
	
	/**
	 * @author Aditya Shekhar
	 * @version 1.0
	 * @since 17/11/2015
	 * @param ArrayList of TransactionReportDTOs
	 * @return java.util.String
	 * @throws JsonSyntaxException,ClassCastException
	 */
	public  String getJsonArrayStringFromDashboardDTOList(final List<TransactionReportDTO> dataBeanList)throws JsonSyntaxException,ClassCastException{
		String jsonString = "";
		Gson gson = new Gson();
		jsonString = gson.toJson(dataBeanList, List.class);
		return jsonString;
	}
	
}
