package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelReader {
	
	
	
	public static String[][] getTestData() {
		
		File excelFile = new File(System.getProperty("user.dir") + File.separator +"src/files/testData.xlsx");

				FileInputStream fis;

				XSSFWorkbook workbook = null;
				
				try {
					fis = new FileInputStream(excelFile);
					workbook = new XSSFWorkbook (fis);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				XSSFSheet sheet = workbook. getSheet( "Sheet1") ; 
				int noOfRows = sheet.getPhysicalNumberOfRows ();
				int noOfColumns = sheet.getRow(0).getLastCellNum( );

				String[ ][] data = new String[noOfRows-1] [noOfColumns];
				for (int i = 0; i < noOfRows-1; i++) {
					for (int j = 0; j < noOfColumns; j++) {
						DataFormatter df = new DataFormatter();
						data[i] [j] = df. formatCellValue(sheet. getRow(i+1).getCell(j));
					}
				}
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return data;
	
	}
	
	
}
