package com.nuccash.payments.jasper.service;
/*
 *Author: Aditya Shekhar
 *Modification Date: 20/11/2015
 *Copyright: Nucleus Software Exports Ltd
 *Description: Service class for Dashboard Report
 */


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import com.nuccash.payments.jasper.dto.TransactionReportDTO;

public class TransactionReportService{
	
	@SuppressWarnings("unchecked")
	public static List<TransactionReportDTO> getDashboardDTOListFromJSON(String jsonString){
		JsonParser  parser = new JsonParser();
                JsonElement elem = parser.parse(jsonString);
                JsonArray jsonArray = elem.getAsJsonArray();
		Gson gson = new Gson();
                //This is done to prevent generic class conversion issues due to Type Erasure
		Type t = new TypeToken<List<TransactionReportDTO>>() {}.getType();
		List<TransactionReportDTO> dataBeanList = (List<TransactionReportDTO>) gson.fromJson(jsonArray.toString(), t);
		return dataBeanList;
	}
	
	public static String getJsonArrayStringFromDashboardDTOList(ArrayList<TransactionReportDTO> dataBeanList){
		String jsonString = "";
		Gson gson = new Gson();
		jsonString = gson.toJson(dataBeanList, ArrayList.class);
		return jsonString;
	}

}