package com.datadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {

	public static String[][] read_Excel() throws IOException {
		
		String fileloc = "./Test_Data/datadriven 1.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(fileloc);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		
		int lastRowNum = sheet.getLastRowNum();							// gives last edited row in a sheet
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("Last Row no : " + lastRowNum);
		System.out.println("Last Cell no : " + lastCellNum);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();		// gives total number of rows in a sheet
		System.out.println("Physical no : " + physicalNumberOfRows);
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter ddf = new DataFormatter();
				String formatCellValue = ddf.formatCellValue(cell);
				System.out.println(formatCellValue);
				data[i-1][j] = formatCellValue;
			}
		}
		wbook.close();
		return data;
	}
	
}
