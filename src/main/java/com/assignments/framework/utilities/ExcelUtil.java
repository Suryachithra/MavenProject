package com.assignments.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<Map<String,String>> readData(String fileName, String sheetName){
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		
		try {
			//Read the excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\TestData\\"+fileName);
			
			//Load the file into excel related class
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			//Read the sheet by providing sheet name
			XSSFSheet sh = wb.getSheet(sheetName);
			
			//Get the number of rows and columns having data
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			//Create loop and load all the data into List<Map>
			
			//Start reading the data from first row till last row
			//(We are not starting from row 0, as we only have column names in row 0)
			for(int r = 1; r<totalRows; r++) {
				
				//create map for each row and load the data
				Map<String, String> rowData = new HashMap<String, String>();
				
				
				//Start reading each column from first to last column
				for(int c = 0; c<totalColumns; c++) {
					
					String key = sh.getRow(0).getCell(c).getStringCellValue(); //get the column name every time as key
					String value = sh.getRow(r).getCell(c).getStringCellValue(); //get the value of each row column as value
					rowData.put(key, value);
				}
				 
				data.add(rowData);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return data;
		
	}

}
