package com.read.files.test;

import java.util.List;
import java.util.Map;

import com.assignments.framework.utilities.ExcelUtil;

public class Assignment17_ReadExcel {

	public static void main(String[] args) {
//		
//		List<Map<String,String>> studentDdata = ExcelUtil.readData("collectionsAssignment.xlsx","StudentDetails");
//		List<Map<String,String>> employeeData = ExcelUtil.readData("collectionsAssignment.xlsx","EmployeeDetails");
		List<Map<String,String>> productData = ExcelUtil.readData("collectionsAssignment.xlsx","ProductDetails");
		System.out.println(productData.get(1).get("Supplier"));
	}

}
